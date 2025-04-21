
package assignment3.models;


public class EmergencyAlert {
   public static void checkVitals(Patient patient, Doctor doctor) {
        if (patient.getVitalsList().isEmpty()) {
            System.out.println("No vitals data available for " + patient.getName());
            return;
        }

        VitalSign latestVital = patient.getVitalsList()
                                       .get(patient.getVitalsList().size() - 1); 

        boolean alert = false;
        StringBuilder alertDetails = new StringBuilder();
        System.out.println("\nChecking vitals for " + patient.getName() + "...");

        if (latestVital.getHeartRate() < 60 || latestVital.getHeartRate() > 100) {
            alertDetails.append("- Abnormal Heart Rate: ").append(latestVital.getHeartRate()).append(" BPM\n");
            alert = true;
        }
        if (latestVital.getOxygenLevel() < 95) {
            alertDetails.append("- Low Oxygen Level: ").append(latestVital.getOxygenLevel()).append("%\n");
            alert = true;
        }
        if (latestVital.getTemperature() < 36.1 || latestVital.getTemperature() > 37.8) {
            alertDetails.append("- Abnormal Temperature: ").append(latestVital.getTemperature()).append("°C\n");
            alert = true;
        }

        if (alert) {
            NotificationService.notifyDoctor(doctor, patient, alertDetails.toString());
        } else {
            System.out.println(" All vitals are within normal range.");
        }
    }

   
  } 

