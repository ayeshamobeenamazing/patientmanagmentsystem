
package assignment3.models;

public class PanicButton {
public static void trigger(Patient patient, Doctor doctor) {
        System.out.println("\n PANIC BUTTON ACTIVATED by " + patient.getName());

        String message = " Patient " + patient.getName() + " has triggered a manual emergency alert!";
        
        // Use NotificationService to notify the doctor
        NotificationService.notifyDoctor(doctor, patient, message);
        
        
    }
}
 

