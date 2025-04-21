
package assignment3.models;
import java.util.Date;

public class ReminderService {
    private final Notifyable notifier;

    public ReminderService(Notifyable notifier) {
        this.notifier = notifier;
    }

    public void sendAppointmentReminder(String contact, String patientName, Date date) {
        String message = "Reminder: Appointment scheduled for " + patientName + " on " + date;
        notifier.sendNotification(contact, message);
    }

    public void sendMedicationReminder(String contact, String patientName, String medicine) {
        String message = "Reminder: " + patientName + ", it's time to take your medicine: " + medicine;
        notifier.sendNotification(contact, message);
    }
}
