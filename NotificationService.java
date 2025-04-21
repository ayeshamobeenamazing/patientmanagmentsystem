
package assignment3.models;

public class NotificationService {
    public static void notifyDoctor(Doctor doctor, Patient patient, String alertMessage) {
        System.out.println("\n Sending Alert to Dr. " + doctor.getName());
        System.out.println("Email: " + doctor.getEmail());
        System.out.println("Patient: " + patient.getName());
        System.out.println("Alert Details:\n" + alertMessage);
    }

    public static void notifyEmergencyContact(String contactName, String phone, String patientName, String alertMessage) {
        System.out.println("\n Notifying emergency contact: " + contactName + " (" + phone + ")");
        System.out.println("Patient: " + patientName + " has critical vital signs.");
        System.out.println("Alert Details:\n" + alertMessage);
    }
}
