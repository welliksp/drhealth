package br.com.wsp.drhealth.model.record;

import br.com.wsp.drhealth.model.Patient;
import br.com.wsp.drhealth.model.enums.Gender;
import org.springframework.hateoas.Link;

//@JsonPropertyOrder({"id", "firstname", "lastname", "gender", "birthdate", "email"})
public record PatientRecord(Integer id,
                            String firstname,
                            String lastname,
                            String email,
                            Gender gender,
                            String birthdate,
                            Link link) {

    public PatientRecord(Patient patient, Link link) {
        this(patient.getId(), patient.getFirstname(), patient.getLastname(), patient.getEmail(), patient.getGender(), patient.getBirthdate(), link);

    }
}