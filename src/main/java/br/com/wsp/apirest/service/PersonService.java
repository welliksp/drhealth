package br.com.wsp.apirest.service;

import br.com.wsp.apirest.exception.ResourceNotFoundException;
import br.com.wsp.apirest.model.Person;
import br.com.wsp.apirest.model.record.PersonRecord;
import br.com.wsp.apirest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public PersonRecord findById(Integer personId) {

        logger.info("find person by id");
        Person person = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        PersonRecord personRecord = new PersonRecord(person);

        return personRecord;
    }

    public PersonRecord save(PersonRecord personRecord) {

        Person person = new Person(personRecord);

        logger.info("save person");
        Person save = personRepository.save(person);

        PersonRecord converted = new PersonRecord(save);
        return converted;

    }

    public PersonRecord update(PersonRecord personRecord) {

        logger.info("Finding one person!");
        var person = personRepository.findById(personRecord.id()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        person.setFirstname(personRecord.firstname());
        person.setLastname(personRecord.lastname());
        person.setBirthdate(personRecord.birthdate());
        person.setEmail(personRecord.email());
        person.setGender(personRecord.gender());

        logger.info("Updating one person!");
        Person save = personRepository.save(person);
        PersonRecord update = new PersonRecord(save);

        return update;
    }

    public void delete(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.deleteById(person.getId());
    }
}
