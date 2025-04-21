
package assignment3.models;

import java.util.ArrayList;


public class MedicalHistory {
  private String patientName;
    private ArrayList<String> consultations; 
    private ArrayList<Prescription> prescriptions;
    private ArrayList<String> diagnoses;      
    private ArrayList<String> treatments; 

 // constructor 
    public MedicalHistory(String patientName) {
        this.patientName = patientName;
        this.consultations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.diagnoses = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }
    public void addDiagnosis(String diagnosis) {
       diagnoses.add(diagnosis);
    }

    
    public void addTreatment(String treatment) {
        treatments.add(treatment);
    }

   
    public void addPrescription(String patient, String medication, String dosage, String schedule) {
        prescriptions.add(new Prescription(patient, medication, dosage, schedule));
    }

   
    public void addConsultation(String consultation) {
        consultations.add(consultation);
    }
    public void displayMedicalHistory() {
        System.out.println("\nMedical History for: " + patientName);

       
        if (consultations.isEmpty()) {
            System.out.println("No past consultations recorded.");
        } else {
            System.out.println("Past Consultations:");
            for (String c : consultations) {
                System.out.println("- " + c);
            }
        }

       
        if (prescriptions.isEmpty()) {
            System.out.println("No past prescriptions.");
        } else {
            System.out.println("\nPrescriptions:");
            for (Prescription p : prescriptions) {
                p.displayPrescription();
            }
        }
    }
  
}
