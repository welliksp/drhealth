package br.com.wsp.drhealth.controller.v1;

import br.com.wsp.drhealth.model.Patient;
import br.com.wsp.drhealth.model.record.PatientRecord;
import br.com.wsp.drhealth.service.PatientService;
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
@RequestMapping(value = "/patient")
@Tag(name = "Patient", description = "Endpoints for Managing Patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find all Patient",
            description = "Find Patient By ID",
            tags = {"Patient"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PatientRecord.class))}),
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<PatientRecord> findPersonById(@PathVariable(value = "id") Integer id) {

        Patient byId = patientService.findById(id);
        Link link = linkTo(methodOn(PatientController.class).findPersonById(byId.getId())).withSelfRel();
        PatientRecord record = new PatientRecord(byId, link);

        return ResponseEntity.ok(record);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Find all Patient",
            description = "Find all Patient",
            tags = {"Patient"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(
                                            implementation = PatientRecord.class)))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<PatientRecord>> findAll() {

        List<Patient> all = patientService.findAll();
        Link link = linkTo(methodOn(PatientController.class).findAll()).withSelfRel();
        List<PatientRecord> recordList = new ArrayList<>();
        all.forEach(r -> recordList.add(new PatientRecord(r, link)));


        return ResponseEntity.ok(recordList);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Create Patient",
            description = "Create Patient",
            tags = {"Patient"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PatientRecord.class))}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<PatientRecord> save(@RequestBody @Valid PatientRecord PatientRecord) {

        Patient save = patientService.save(PatientRecord);
        Link link = linkTo(methodOn(PatientController.class).findPersonById(save.getId())).withSelfRel();
        PatientRecord record = new PatientRecord(save, link);

        return ResponseEntity.ok(record);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Update Patient",
            description = "Update Patient",
            tags = {"Patient"},
            responses = {
                    @ApiResponse(description = "Sucess", responseCode = "200",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PatientRecord.class))}),
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<PatientRecord> update(@RequestBody @Valid PatientRecord personVO) {

        Patient save = patientService.update(personVO);
        Link link = linkTo(methodOn(PatientController.class).findPersonById(save.getId())).withSelfRel();
        PatientRecord record = new PatientRecord(save, link);

        return ResponseEntity.ok(record);
    }

    @DeleteMapping()
    @Operation(summary = "Delete Patient",
            description = "Delete Patient",
            tags = {"Patient"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "201", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<?> delete(@RequestParam Integer id) {

        patientService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
