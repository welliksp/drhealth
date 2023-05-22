package br.com.wsp.apirest.model.record;

import br.com.wsp.apirest.model.Person;

public record PersonRecord(Integer id, String firstname, String lastname,String email, String gender, String birthdate) {

    public PersonRecord(Person person) {
        this(person.getId(), person.getFirstname(), person.getLastname(), person.getEmail(), person.getGender(), person.getBirthdate());

    }
}
