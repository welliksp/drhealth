package br.com.wsp.apirest.service;

import br.com.wsp.apirest.exception.ResourceNotFoundException;
import br.com.wsp.apirest.model.Person;
import br.com.wsp.apirest.repository.PersonRepository;
import br.com.wsp.apirest.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public List<PersonVO> findAll() {

        logger.info("find person by id");
        List<Person> personList = personRepository.findAll();

        List<PersonVO> personVO = new ArrayList<>();
        personList.forEach(p -> {
            PersonVO personVO1 = new PersonVO(p);
            personVO.add(personVO1);
        });

        return personVO;
    }

    public PersonVO findById(Integer personId) {

        logger.info("find person by id");
        Person person = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        PersonVO personVO = new PersonVO(person);

        return personVO;
    }

    public PersonVO save(PersonVO personVO) {

        Person person = new Person(personVO);

        logger.info("save person");
        Person save = personRepository.save(person);

        PersonVO converted = new PersonVO(save);
        return converted;

    }

    public PersonVO update(PersonVO personVO) {

        logger.info("Finding one person!");
        var person = personRepository.findById(personVO.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        person.setFirstname(personVO.getFirstname());
        person.setLastname(personVO.getLastname());
        person.setBirthdate(personVO.getBirthdate());
        person.setEmail(personVO.getEmail());
        person.setGender(personVO.getGender());

        logger.info("Updating one person!");
        Person save = personRepository.save(person);
        PersonVO update = new PersonVO(save);

        return update;
    }

    public void delete(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        personRepository.deleteById(person.getId());
    }
}
