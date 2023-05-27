package br.com.wsp.drhealth.repository;

import br.com.wsp.drhealth.model.Doctor;
import br.com.wsp.drhealth.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
