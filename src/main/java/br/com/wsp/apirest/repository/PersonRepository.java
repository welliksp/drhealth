package br.com.wsp.apirest.repository;

import br.com.wsp.apirest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
