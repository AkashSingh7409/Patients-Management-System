package com.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.entities.Patient;
import com.patient.services.PatientService;

@RestController
public class PatientController {

	@Autowired //this keyword creates an object of PatientServiceImpl through PatientService and injected in patientService variable
	public PatientService patientService;
	
	@GetMapping("/home")
	public String home() {
		return "This is home page..!";
	}
	
	//get the patients list with details
	@GetMapping("/patient")        /* @RequestMapping(path="/patient", method = RequestMethod.GET) */
	public List<Patient> getPatients() {
		return this.patientService.getPatients(); 
	}
	
	//get a particular patient details
    @GetMapping("/patient/{patientId}") 
    public Patient getPatient(@PathVariable String patientId) {
    	return this.patientService.getPatient(Long.parseLong(patientId)); 
	}
    
    //add new patient details
    @PostMapping("/patient")
    public Patient addPatient(@RequestBody Patient patient) {
    	return this.patientService.addPatient(patient);
    }
    
    //update a existing patient details
    @PutMapping("/patient/{patientId}")
    public Patient updatePatient(@RequestBody Patient patient, @PathVariable("patientId") String patientId) {
        this.patientService.updatePatient(patient, Long.parseLong(patientId));
    	return patient;
    	
    }
    
    //delete a particular employee which exist in our table
    @DeleteMapping("/patient/{patientId}")
    public void deletepatient(@PathVariable ("patientId") String patientId) {
		this.patientService.deletepatient(Long.parseLong(patientId));
	}
    
}






