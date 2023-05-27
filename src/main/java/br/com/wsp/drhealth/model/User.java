package br.com.wsp.drhealth.model;

import br.com.wsp.drhealth.model.enums.Gender;
import br.com.wsp.drhealth.model.record.v1.UserRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User implements Serializable {

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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String birthdate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp created_at;

    public User() {
    }

    public User(UserRecord record) {
        this.firstname = record.firstname();
        this.lastname = record.lastname();
        this.birthdate = record.birthdate();
        this.email = record.email();
        this.gender = record.gender();
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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
