package br.com.wsp.apirest.vo.v1;

import br.com.wsp.apirest.model.Person;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"id", "firstname", "lastname", "gender", "birthdate", "email"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {
    private Integer key;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String birthdate;

    public PersonVO(Person person) {
        this.firstname = person.getFirstname();
        this.lastname = person.getLastname();
        this.gender = person.getGender();
        this.email = person.getEmail();
        this.birthdate = person.getBirthdate();
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}