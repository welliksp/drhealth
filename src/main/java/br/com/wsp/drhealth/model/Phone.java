package br.com.wsp.drhealth.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ddi;
    private Long ddd;
    private Long prefix;
    private Long suffix;
    private String country;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp createdAt;

    public Phone() {
    }

    public Phone(Long id, Long ddi, Long ddd, Long prefix, Long suffix, String country, Timestamp createdAt) {
        this.id = id;
        this.ddi = ddi;
        this.ddd = ddd;
        this.prefix = prefix;
        this.suffix = suffix;
        this.country = country;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDdi() {
        return ddi;
    }

    public void setDdi(Long ddi) {
        this.ddi = ddi;
    }

    public Long getDdd() {
        return ddd;
    }

    public void setDdd(Long ddd) {
        this.ddd = ddd;
    }

    public Long getPrefix() {
        return prefix;
    }

    public void setPrefix(Long prefix) {
        this.prefix = prefix;
    }

    public Long getSuffix() {
        return suffix;
    }

    public void setSuffix(Long suffix) {
        this.suffix = suffix;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
