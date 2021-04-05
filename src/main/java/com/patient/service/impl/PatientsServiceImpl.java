package com.patient.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.patient.entities.Patient;
import com.patient.services.PatientService;

@Service
public class PatientsServiceImpl implements PatientService {

	List<Patient> list;
	
	public PatientsServiceImpl() {
		list=new ArrayList<>();
		list.add(new Patient(1724010006,"Akash Singh","Delhi","7409491538"));
		list.add(new Patient(1724010015,"Deepshika Chauhan","Ghaziabad","8810537548"));
		list.add(new Patient(1724010042,"Somesh Raj","Noida","8948939898"));
	}
	
	@Override
	public List<Patient> getPatients() {
		return list;
	}

	@Override
	public Patient getPatient(long patientId) {
		
		Patient p = null;
		for(Patient patient : list) {
			if(patient.getId() == patientId) {
				p = patient;
			}
		}
		return p;
	}

	@Override
	public Patient addPatient(Patient patient) {
		list.add(patient);
		return patient;
	}

	@Override
	public void updatePatient(Patient patient, long patientId) {
	 for(Patient p :list) {
			if(p.getId() == patientId) {
				p.setName(patient.getName());
				p.setAddress(patient.getAddress());
				p.setContact(patient.getContact());
			}
		}	
	}

	@Override
	public void deletepatient(long patientId) {
		list=list.stream().filter(patient ->patient.getId()!=patientId).collect(Collectors.toList());
		
	}

}
