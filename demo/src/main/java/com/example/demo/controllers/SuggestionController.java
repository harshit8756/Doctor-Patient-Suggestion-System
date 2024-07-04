package com.example.demo.controllers;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.services.DoctorService;
import com.example.demo.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuggestionController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/suggestions/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        Patient patient = patientService.findPatientById(patientId);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }

        String city = patient.getCity();
        String symptom = patient.getSymptom();
        String speciality = getSpecialityForSymptom(symptom);

        if (speciality.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid symptom");
        }

        List<Doctor> doctors = doctorService.findDoctorsByCityAndSpeciality(city, speciality);

        if (doctors.isEmpty()) {
            if (!isCitySupported(city)) {
                return ResponseEntity.ok("We are still waiting to expand to your location");
            } else {
                return ResponseEntity.ok("There isn’t any doctor present at your location for your symptom");
            }
        }

        return ResponseEntity.ok(doctors);
    }

    private String getSpecialityForSymptom(String symptom) {
        switch (symptom) {
            case "Arthritis":
            case "Back Pain":
            case "Tissue injuries":
                return "Orthopaedic";
            case "Dysmenorrhea":
                return "Gynecology";
            case "Skin infection":
            case "Skin burn":
                return "Dermatology";
            case "Ear pain":
                return "ENT";
            default:
                return "";
        }
    }

    private boolean isCitySupported(String city) {
        return city.equals("Delhi") || city.equals("Noida") || city.equals("Faridabad");
    }
}