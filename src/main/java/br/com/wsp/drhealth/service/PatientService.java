package br.com.wsp.drhealth.service;

import br.com.wsp.drhealth.exception.ResourceNotFoundException;
import br.com.wsp.drhealth.model.Patient;
import br.com.wsp.drhealth.model.record.PatientRecord;
import br.com.wsp.drhealth.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PatientService {
    private final Logger logger = Logger.getLogger(PatientService.class.getName());

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient findById(Integer personId) {

        logger.info("find person by id");
        return patientRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Patient save(PatientRecord patientRecord) {

        Patient patient = new Patient(patientRecord);

        logger.info("save patient");
        return patientRepository.save(patient);

    }

    public Patient update(PatientRecord patientRecord) {

        logger.info("Finding one person!");
        var person = patientRepository.findById(patientRecord.id()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        person.setFirstname(patientRecord.firstname());
        person.setLastname(patientRecord.lastname());
        person.setBirthdate(patientRecord.birthdate());
        person.setEmail(patientRecord.email());
        person.setGender(patientRecord.gender());

        logger.info("Updating one person!");
        return patientRepository.save(person);
    }

    public void delete(Integer id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        patientRepository.deleteById(patient.getId());
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
