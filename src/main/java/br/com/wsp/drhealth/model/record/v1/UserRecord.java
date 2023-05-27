package br.com.wsp.drhealth.model.record.v1;

import br.com.wsp.drhealth.model.User;
import br.com.wsp.drhealth.model.enums.Gender;
import org.springframework.hateoas.Link;

//@JsonPropertyOrder({"id", "firstname", "lastname", "gender", "birthdate", "email"})
public record UserRecord(Integer id,
                         String firstname,
                         String lastname,
                         String email,
                         Gender gender,
                         String birthdate,
                         Link link) {

    public UserRecord(User user, Link link) {
        this(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getGender(), user.getBirthdate(), link);

    }
}