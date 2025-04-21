
package assignment3.models;

import java.util.ArrayList;

public class Administrator extends User {
    private ArrayList<Doctor> doctorsList;
    private ArrayList<Patient> patientsList;
    private ArrayList<String> systemLogs; 

 // constructor   
    public Administrator(String name, String email, String id) {
        super(name, email, id);
        this.doctorsList = new ArrayList<>();
        this.patientsList = new ArrayList<>();
        this.systemLogs = new ArrayList<>();
    }
    // getters 
    public ArrayList<Doctor> getDoctorsList() { 
        return doctorsList; 
    }
    public ArrayList<Patient> getPatientsList() { 
        return patientsList; 
    }
    public ArrayList<String> getSystemLogs() { 
        return systemLogs; 
    }
    
    // admin methods
     public void addDoctor(Doctor doctor) {
        doctorsList.add(doctor);
        logAction("Doctor " + doctor.getName() + " added.");
    }

   
    public void removeDoctor(Doctor doctor) {
        if (doctorsList.remove(doctor)) {
            logAction("Doctor " + doctor.getName() + " removed.");
        } else {
            System.out.println("Doctor not found in system.");
        }
    }

   
    public void addPatient(Patient patient) {
        patientsList.add(patient);
        logAction("Patient " + patient.getName() + " added.");
    }

   
    public void removePatient(Patient patient) {
        if (patientsList.remove(patient)) {
            logAction("Patient " + patient.getName() + " removed.");
        } else {
            System.out.println("Patient not found in system.");
        }
    }

    
    public void viewDoctors() {
        System.out.println("\nList of Doctors:");
        if (doctorsList.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor d : doctorsList) {
                System.out.println(" | Name: " + d.getName());
            }
        }
    }

   
    public void viewPatients() {
        System.out.println("\nList of Patients:");
        if (patientsList.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            for (Patient p : patientsList) {
                System.out.println(" | Name: " + p.getName());
            }
        }
    }

  // admin control methods 
    private void logAction(String action) {
        systemLogs.add(action);
        System.out.println("[LOG] " + action);
    }

   
    public void viewSystemLogs() {
        System.out.println("\nSystem Logs:");
        if (systemLogs.isEmpty()) {
            System.out.println("No logs available.");
        } else {
            for (String log : systemLogs) {
                System.out.println(log);
            }
        }
    }
}
