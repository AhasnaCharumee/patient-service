package com.hospital.patient_service.service;

import com.hospital.patient_service.model.Patient;
import com.hospital.patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient existing = patientRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updatedPatient.getName());
            existing.setAge(updatedPatient.getAge());
            existing.setGender(updatedPatient.getGender());
            existing.setContactNumber(updatedPatient.getContactNumber());
            existing.setAddress(updatedPatient.getAddress());
            return patientRepository.save(existing);
        }
        return null;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}