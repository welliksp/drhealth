package br.com.wsp.drhealth.controller.v1;

import br.com.wsp.drhealth.model.User;
import br.com.wsp.drhealth.model.record.v1.UserRecord;
import br.com.wsp.drhealth.service.PersonService;
import br.com.wsp.drhealth.util.MediaType;
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
@Tag(name = "User", description = "Endpoints for Managing User")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find all User",
            description = "Find User By ID",
            tags = {"User"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserRecord.class))}),
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<UserRecord> findPersonById(@PathVariable(value = "id") Integer id) {

        User byId = personService.findById(id);
        Link link = linkTo(methodOn(PersonController.class).findPersonById(byId.getId())).withSelfRel();
        UserRecord record = new UserRecord(byId, link);

        return ResponseEntity.ok(record);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find all User",
            description = "Find all User",
            tags = {"User"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(
                                                implementation = UserRecord.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<UserRecord>> findAll() {

        List<User> all = personService.findAll();
        Link link = linkTo(methodOn(PersonController.class).findAll()).withSelfRel();
        List<UserRecord> recordList = new ArrayList<>();
        all.forEach(r -> recordList.add(new UserRecord(r, link)));


        return ResponseEntity.ok(recordList);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Create User",
            description = "Create User",
            tags = {"User"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserRecord.class))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<UserRecord> save(@RequestBody @Valid UserRecord userRecord) {

        User save = personService.save(userRecord);
        Link link = linkTo(methodOn(PersonController.class).findPersonById(save.getId())).withSelfRel();
        UserRecord record = new UserRecord(save, link);

        return ResponseEntity.ok(record);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Update User",
            description = "Update User",
            tags = {"User"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UserRecord.class))}),
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<UserRecord> update(@RequestBody @Valid UserRecord personVO) {

        User save = personService.update(personVO);
        Link link = linkTo(methodOn(PersonController.class).findPersonById(save.getId())).withSelfRel();
        UserRecord record = new UserRecord(save, link);

        return ResponseEntity.ok(record);
    }

    @DeleteMapping()
    @Operation(summary = "Delete User",
            description = "Delete User",
            tags = {"User"},
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
