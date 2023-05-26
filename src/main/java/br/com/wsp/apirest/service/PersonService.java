package br.com.wsp.apirest.service;

import br.com.wsp.apirest.exception.ResourceNotFoundException;
import br.com.wsp.apirest.model.Person;
import br.com.wsp.apirest.model.record.v1.PersonRecord;
import br.com.wsp.apirest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Integer personId) {

        logger.info("find person by id");
        return personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person save(PersonRecord personRecord) {

        Person person = new Person(personRecord);

        logger.info("save person");
        return personRepository.save(person);

    }

    public Person update(PersonRecord personRecord) {

        logger.info("Finding one person!");
        var person = personRepository.findById(personRecord.id()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        person.setFirstname(personRecord.firstname());
        person.setLastname(personRecord.lastname());
        person.setBirthdate(personRecord.birthdate());
        person.setEmail(personRecord.email());
        person.setGender(personRecord.gender());

        logger.info("Updating one person!");
        return personRepository.save(person);
    }

    public void delete(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.deleteById(person.getId());
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
