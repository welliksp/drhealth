package br.com.wsp.apirest.model;

import br.com.wsp.apirest.vo.v1.PersonVO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name", nullable = false)
    @NotNull
    private String firstname;
    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastname;
    @NotNull
    @Email
    private String email;
    private String gender;
    private String birthdate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp created_at;

    public Person() {
    }

    public Person(PersonVO personVO) {
        this.firstname = personVO.getFirstname();
        this.lastname = personVO.getLastname();
        this.birthdate = personVO.getBirthdate();
        this.email = personVO.getEmail();
        this.gender = personVO.getGender();
        this.created_at = Timestamp.valueOf(LocalDateTime.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
