package br.com.wsp.drhealth.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Long number;
    private String state;
    private String city;
    private String zipcode;
    private String complement;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp created_ate;

    public Address(Long id, String street, Long number, String state, String city, String zipcode, String complement, Timestamp created_ate) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.complement = complement;
        this.created_ate = created_ate;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Timestamp getCreated_ate() {
        return created_ate;
    }

    public void setCreated_ate(Timestamp created_ate) {
        this.created_ate = created_ate;
    }
}
