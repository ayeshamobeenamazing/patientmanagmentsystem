
package assignment3.models;

public class Prescription {
    private String patientName;
    private String medication;
    private String dosage;
    private String schedule;

  // constructor  
    public Prescription(String patientName, String medication, String dosage, String schedule) {
        this.patientName = patientName;
        this.medication = medication;
        this.dosage = dosage;
        this.schedule = schedule;
    }
    // getters
    public String getPatientName() { 
        return patientName; 
    }
    public String getMedication() { 
        return medication; 
    }
    public String getDosage() { 
        return dosage; 
    }
    public String getSchedule() { 
        return schedule; 
    }
    public void displayPrescription() {
        System.out.println("\nPrescription for: " + patientName);
        System.out.println("Medication: " + medication);
        System.out.println("Dosage: " + dosage);
        System.out.println("Schedule: " + schedule);
    }
}
