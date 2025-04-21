
package assignment3.models;

import java.util.ArrayList;

public class VitalsDatabase {
    private ArrayList<PatientVitalRecord> vitals = new ArrayList<>();

    public void addVital(Patient patient, VitalSign vital) {
        vitals.add(new PatientVitalRecord(patient, vital));
    }

    public void displayVitals() {
        for (PatientVitalRecord record : vitals) {
            System.out.println("Patient: " + record.getPatient().getName());
            System.out.println(record.getVital());
            System.out.println();
        }
    }

    private static class PatientVitalRecord {
        private Patient patient;
        private VitalSign vital;

        public PatientVitalRecord(Patient patient, VitalSign vital) {
            this.patient = patient;
            this.vital = vital;
        }

        public Patient getPatient() {
            return patient;
        }

        public VitalSign getVital() {
            return vital;
        }
    }
}
