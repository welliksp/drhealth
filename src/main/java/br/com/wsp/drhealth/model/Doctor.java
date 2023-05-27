package br.com.wsp.drhealth.model;

import br.com.wsp.drhealth.model.enums.CRM;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String crm;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "crm_status")
    private CRM crmStatus;
    @NotNull
    private String specialty;
    @NotNull
    private String registration;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Timestamp registrationDate;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "first_registration_UF")
    private String firstRegistrationUF;
    //    private Address address;
//    private Phone phone;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Timestamp createAt;

    public Doctor() {
    }

    public Doctor(Integer id, String name, String crm, CRM crmStatus, String specialty, String registration, Timestamp registrationDate, String firstRegistrationUF, Timestamp createAt) {
        this.id = id;
        this.name = name;
        this.crm = crm;
        this.crmStatus = crmStatus;
        this.specialty = specialty;
        this.registration = registration;
        this.registrationDate = registrationDate;
        this.firstRegistrationUF = firstRegistrationUF;
        this.createAt = createAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public CRM getCrmStatus() {
        return crmStatus;
    }

    public void setCrmStatus(CRM crmStatus) {
        this.crmStatus = crmStatus;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFirstRegistrationUF() {
        return firstRegistrationUF;
    }

    public void setFirstRegistrationUF(String firstRegistrationUF) {
        this.firstRegistrationUF = firstRegistrationUF;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
}