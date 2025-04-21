
package assignment3.models;

import java.util.ArrayList;


public class AppointmentManager {
     private ArrayList<Appointment> appointments; 

   
    public AppointmentManager(ArrayList<Appointment> appointments) {
        this.appointments = new ArrayList<>();
    }
    public void requestAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment requested for " + appointment.getPatient() + " with " + appointment.getDoctor());
    }
     public void approveAppointment(Appointment appointment) {
        appointment.setStatus("Approved");
         System.out.println("Appointment approved for " + appointment.getPatient());
    }

    
    public void rejectAppointment(Appointment appointment) {
        appointment.setStatus("Rejected");
        System.out.println(" Appointment rejected for " + appointment.getPatient());
    }
     public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
        System.out.println("Appointment canceled for " + appointment.getPatient());
    }
    public void setAppointments(ArrayList<Appointment> appointments){
        this.appointments = appointments;
    }
    public void displayAppointments() {
      if (appointments.isEmpty()) {
          System.out.println("No appointments scheduled.");
          return;
      }

      System.out.println("\nList of Appointments:");
      for (Appointment a : appointments) {
          a.displayAppointment();
      }
    }
      public Appointment findAppointment(String patientName, String doctorName) {
        for (Appointment a : appointments) {
            if (a.getPatient().equalsIgnoreCase(patientName) && a.getDoctor().equalsIgnoreCase(doctorName)) {
                return a;
            }
        }
        return null; 
    }
}
