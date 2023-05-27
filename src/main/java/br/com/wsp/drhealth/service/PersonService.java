package br.com.wsp.drhealth.service;

import br.com.wsp.drhealth.exception.ResourceNotFoundException;
import br.com.wsp.drhealth.model.User;
import br.com.wsp.drhealth.model.record.v1.UserRecord;
import br.com.wsp.drhealth.repository.PersonRepository;
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

    public User findById(Integer personId) {

        logger.info("find person by id");
        return personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public User save(UserRecord userRecord) {

        User user = new User(userRecord);

        logger.info("save user");
        return personRepository.save(user);

    }

    public User update(UserRecord userRecord) {

        logger.info("Finding one person!");
        var person = personRepository.findById(userRecord.id()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        person.setFirstname(userRecord.firstname());
        person.setLastname(userRecord.lastname());
        person.setBirthdate(userRecord.birthdate());
        person.setEmail(userRecord.email());
        person.setGender(userRecord.gender());

        logger.info("Updating one person!");
        return personRepository.save(person);
    }

    public void delete(Integer id) {
        User user = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.deleteById(user.getId());
    }

    public List<User> findAll() {
        return personRepository.findAll();
    }
}
