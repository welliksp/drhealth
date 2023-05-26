package br.com.wsp.apirest.controller.v1;

import br.com.wsp.apirest.model.Person;
import br.com.wsp.apirest.model.record.v1.PersonRecord;
import br.com.wsp.apirest.service.PersonService;
import br.com.wsp.apirest.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(value = "/person/v1")
@Tag(name = "People", description = "Endpoints for Managing People")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find all People",
            description = "Find People By ID",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PersonRecord.class))}),
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<PersonRecord> findPersonById(@PathVariable(value = "id") Integer id) {

        Person byId = personService.findById(id);
        Link link = linkTo(methodOn(PersonController.class).findPersonById(byId.getId())).withSelfRel();
        PersonRecord record = new PersonRecord(byId, link);

        return ResponseEntity.ok(record);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find all People",
            description = "Find all People",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(
                                                implementation = PersonRecord.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<PersonRecord>> findAll() {

        List<Person> all = personService.findAll();
        Link link = linkTo(methodOn(PersonController.class).findAll()).withSelfRel();
        List<PersonRecord> recordList = new ArrayList<>();
        all.forEach(r -> recordList.add(new PersonRecord(r, link)));


        return ResponseEntity.ok(recordList);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Create People",
            description = "Create People",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PersonRecord.class))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<PersonRecord> save(@RequestBody @Valid PersonRecord personRecord) {

        Person save = personService.save(personRecord);
        Link link = linkTo(methodOn(PersonController.class).findPersonById(save.getId())).withSelfRel();
        PersonRecord record = new PersonRecord(save, link);

        return ResponseEntity.ok(record);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Update People",
            description = "Update People",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PersonRecord.class))}),
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<PersonRecord> update(@RequestBody @Valid PersonRecord personVO) {

        Person save = personService.update(personVO);
        Link link = linkTo(methodOn(PersonController.class).findPersonById(save.getId())).withSelfRel();
        PersonRecord record = new PersonRecord(save, link);

        return ResponseEntity.ok(record);
    }

    @DeleteMapping()
    @Operation(summary = "Delete People",
            description = "Delete People",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<?> delete(@RequestParam Integer id) {

        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
