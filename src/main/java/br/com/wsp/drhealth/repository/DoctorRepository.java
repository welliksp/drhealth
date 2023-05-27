package br.com.wsp.drhealth.repository;

import br.com.wsp.drhealth.model.Doctor;
import br.com.wsp.drhealth.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
