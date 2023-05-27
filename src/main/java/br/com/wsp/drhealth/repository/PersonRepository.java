package br.com.wsp.drhealth.repository;

import br.com.wsp.drhealth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<User, Integer> {

}
