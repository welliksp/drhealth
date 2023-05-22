package br.com.wsp.apirest.controller;

import br.com.wsp.apirest.model.record.PersonRecord;
import br.com.wsp.apirest.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRecord> findPersonById(@RequestParam Integer id) {

        PersonRecord byId = personService.findById(id);

        return ResponseEntity.ok(byId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRecord> save(@RequestBody @Valid PersonRecord personRecord) {

        PersonRecord save = personService.save(personRecord);

        return ResponseEntity.ok(save);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonRecord> update(@RequestBody @Valid PersonRecord personRecord) {

        PersonRecord save = personService.update(personRecord);

        return ResponseEntity.ok(save);
    }
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestParam Integer id) {

        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
