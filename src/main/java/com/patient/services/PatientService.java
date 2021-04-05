package com.patient.services;

import java.util.List;

import com.patient.entities.Patient;

public interface PatientService {

	//It is used for easy coupling
	public List<Patient> getPatients();
	
	public Patient getPatient(long patientId);
	
	public Patient addPatient(Patient patient);
	
	public void updatePatient(Patient patient, long patientId);

	public void deletepatient(long patientId);
	
	

	
	
}
