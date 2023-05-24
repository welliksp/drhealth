package br.com.wsp.apirest.controller;

import br.com.wsp.apirest.vo.v1.PersonVO;
import br.com.wsp.apirest.service.PersonService;
import br.com.wsp.apirest.util.MediaType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<PersonVO> findPersonById(@PathVariable(value = "id") Integer id) {

        PersonVO byId = personService.findById(id);

        return ResponseEntity.ok(byId);
    }
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<List<PersonVO>> findAll() {

        List<PersonVO> all = personService.findAll();

        return ResponseEntity.ok(all);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<PersonVO> save(@RequestBody @Valid PersonVO personVO) {

        PersonVO save = personService.save(personVO);

        return ResponseEntity.ok(save);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public ResponseEntity<PersonVO> update(@RequestBody @Valid PersonVO personVO) {

        PersonVO save = personService.update(personVO);

        return ResponseEntity.ok(save);
    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestParam Integer id) {

        personService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
