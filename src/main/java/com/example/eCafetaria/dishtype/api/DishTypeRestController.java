package com.example.eCafetaria.dishtype.api;

import com.example.eCafetaria.dishtype.application.*;
import com.example.eCafetaria.dishtype.domain.Acronym;
import com.example.eCafetaria.dishtype.domain.exceptions.InvalidLengthForDescription;
import com.example.eCafetaria.dishtype.domain.exceptions.NoSpecialCharacters;
import com.example.eCafetaria.dishtype.domain.exceptions.NotASingleWord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;


/**
 * The DishType REST controller.
 */
@RestController
@RequestMapping("/api/dishtype")
public class DishTypeRestController {
    /**
     * The Find dish type controller.
     */
    @Autowired
    FindDishTypeController findDishTypeController;
    /**
     * The Create dish type controller.
     */
    @Autowired
    CreateDishTypeController createDishTypeController;
    /**
     * The Dish type mapper.
     */
    @Autowired
    DishTypeMapper dishTypeMapper;
    /**
     * The Update dish type controller.
     */
    @Autowired
    UpdateDishTypeController updateDishTypeController;

    /**
     * Search all existing dish types.
     *
     * @return the iterable
     */
    @Operation(summary = "Gets all Dish Types.")
    @ApiResponse(description = "Success", responseCode = "200", content = { @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = DishTypeDTO.class))) })
    @GetMapping
    public Iterable<DishTypeDTO> searchAllDishType() {
        Iterable<DishTypeDTO> dishTypeDTOList = new ArrayList<>();
        dishTypeDTOList = findDishTypeController.findAll();
        return dishTypeDTOList;
    }

    /**
     * Search by acronym response entity.
     *
     * @param acronym the acronym
     * @return the response entity
     */
    @Operation(summary = "Get a dish type by acronym.")
    @GetMapping("/{acronym}")
    public ResponseEntity<DishTypeDTO> searchByAcronym(@PathVariable("acronym") @Parameter(description = "The acronym of the dish type to find.") Acronym acronym) {
        var dishTypeChecker = findDishTypeController.findByAcronym(acronym).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dish Type not Found"));
        return ResponseEntity.ok().eTag(Long.toString(dishTypeChecker.getVersion())).body(dishTypeMapper.toDto(dishTypeChecker));
    }

    /**
     * Create or update dish type response entity.
     *
     * @param request        the request
     * @param acronym        the acronym
     * @param descriptionDto the description dto
     * @return the response entity
     */
    @Operation(description = "To create or update the dish type by acronym.")
    @PutMapping("/{acronym}")
    public ResponseEntity<DishTypeDTO> CreateOrUpdateDishType(final WebRequest request, @PathVariable("acronym") @Parameter(description = "The acronym of the dishtype to create/replace.") DishTypeAcronymDTO acronym, @Valid @RequestBody DishTypeDescriptionDTO descriptionDto) {
        final String ifMatchValue = request.getHeader("if-Match");
        if (ifMatchValue == null || ifMatchValue.isEmpty()) {
            try {
                final var dishType = createDishTypeController.createDishType(acronym, descriptionDto);
                final var dishTypeURI = ServletUriComponentsBuilder.fromCurrentRequestUri().pathSegment(dishType.getAcronym().obtainAcronym()).build().toUri();
                return ResponseEntity.created(dishTypeURI).eTag(Long.toString(dishType.getVersion())).body(dishTypeMapper.toDto(dishType));
            } catch (NotASingleWord | NoSpecialCharacters | StringIndexOutOfBoundsException | IllegalArgumentException | InvalidLengthForDescription exception) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
        try{
            final var dishType = updateDishTypeController.updateDishType(getVersionFromIfMatchHeader(ifMatchValue), acronym, descriptionDto);
            return ResponseEntity.ok().eTag(Long.toString(dishType.getVersion())).body(dishTypeMapper.toDto(dishType));
        } catch (IllegalArgumentException exception){
         throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
         }

    }

    private Long getVersionFromIfMatchHeader(final String ifMatchHeader){
        if(ifMatchHeader.startsWith("\"")){
            return Long.parseLong(ifMatchHeader.substring(1, ifMatchHeader.length() -1));
        }
        return Long.parseLong(ifMatchHeader);
    }
}
