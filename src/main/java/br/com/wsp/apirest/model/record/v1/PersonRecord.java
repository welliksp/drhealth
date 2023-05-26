package br.com.wsp.apirest.model.record.v1;

import br.com.wsp.apirest.model.Person;
import br.com.wsp.apirest.model.enums.Gender;
import org.springframework.hateoas.Link;

//@JsonPropertyOrder({"id", "firstname", "lastname", "gender", "birthdate", "email"})
public record PersonRecord(Integer id,
                           String firstname,
                           String lastname,
                           String email,
                           Gender gender,
                           String birthdate,
                           Link link) {

    public PersonRecord(Person person, Link link) {
        this(person.getId(), person.getFirstname(), person.getLastname(), person.getEmail(), person.getGender(), person.getBirthdate(), link);

    }
}