
package assignment3;
import assignment3.models.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
         System.out.println("Hallelujah");
        // Sample data for testing
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();
        AppointmentManager appointmentManager = new AppointmentManager(appointments);
        Administrator admin = new Administrator("Admin Tanisha", "tanisha@hotmail.com", "a001");

        // Adding sample doctors and patients
        Doctor doctor1 = new Doctor("Dr. Ali", "ali@hospital.com", "d101", "Cardiologist");
        Doctor doctor2 = new Doctor("Dr. Sarah", "sarah@clinic.com", "d102", "Neurologist");
        doctors.add(doctor1);
        doctors.add(doctor2);
        
        Patient patient1 = new Patient("John Doe", "john@gmail.com", "p201");
        Patient patient2 = new Patient("Emma Watson", "emma@gmail.com", "p202");
        patients.add(patient1);
        patients.add(patient2);
        while (true) {
            System.out.println("\n**** Remote Health Monitoring System ****");
            System.out.println("1. Login as a Patient");
            System.out.println("2. Login as a Doctor");
            System.out.println("3. Login as an Administrator");
            System.out.println("4. Manage Appointments");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1:
                    PatientLogin(scanner, patients, appointments, doctors);
                    break;
                case 2:
                    DoctorLogin(scanner, doctors, patients, appointments);
                    break;
                case 3:
                    AdministratorLogin(scanner, admin, patients, doctors);
                    break;
                case 4:
                    AppointmentManagerLogin(
                            scanner, 
                            appointmentManager, 
                            doctors, 
                            patients,
                            appointments);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
     // PATIENT LOGIN FUNCTION
    private static void PatientLogin(
            Scanner scanner, 
            ArrayList<Patient> patients,
            ArrayList<Appointment> appointments,
            ArrayList<Doctor> doctors) {
        System.out.print("\nEnter Patient ID: ");
        String id = scanner.nextLine();
        System.out.println(id);
        Patient patient = findPatientById(patients, id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        while (true) {
            System.out.println("\n[Patient Menu]");
            System.out.println("[1] Upload Vital Signs");
            System.out.println("[2] View Doctor Feedback");
            System.out.println("[3] Schedule an Appointment");
            System.out.println("[4] View My Appointments");
            System.out.println("[5] Trigger Emergency Panic Button");
            System.out.println("[6] Send Message to Doctor");
            System.out.println("[7] View Chat History");
            System.out.println("[8] Start Video Call");
            System.out.println("[9] Exit Patient Menu");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Heart Rate: ");
                    int hr = scanner.nextInt();
                    System.out.print("Enter Oxygen Level: ");
                    int oxy = scanner.nextInt();
                    System.out.print("Enter Temperature: ");
                    double temp = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Blood pressure: ");
                    String press = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Select your Doctor:");
    for (Doctor d : doctors) {
        System.out.println(d.getId() + " - Dr. " + d.getName());
    }

    Doctor selectedDoctor = null;
    while (selectedDoctor == null) {
        System.out.print("Enter Doctor ID: ");
        String docId = scanner.nextLine();
        for (Doctor d : doctors) {
            if (d.getId().equals(docId)) {
                selectedDoctor = d;
                break;
            }
        }
        if (selectedDoctor == null) {
            System.out.println("Invalid ID. Try again.");
        }
    }
                    
                    VitalSign vital = new VitalSign(hr, oxy, temp, press);
                    patient.uploadVitals(vital, selectedDoctor);
                    break;
                case 2:
                    patient.viewFeedback();
                    break;
                case 3:
                    ArrayList<String> doctorIds = new ArrayList();
                    for(Doctor d: doctors){
                            doctorIds.add(d.getId());
                        }
                    String doctorId;
                    do{
                        for(String identity: doctorIds){
                            System.out.println(identity);
                        }
                        System.out.println("Pick a Doctor Id");
                        doctorId = scanner.nextLine();
                    } while(!doctorIds.contains(doctorId));
                    System.out.println("Enter Appointment Date: ");
                    String date = scanner.nextLine();
                    Appointment appointment = new Appointment(date, doctorId, patient.getId());
                    appointments.add(appointment);
                    break;
                case 4:
                    for (Appointment a : appointments) {
                        if(a.getPatient().equals(patient.getId())){
                            a.displayAppointment();   
                        }
                    }
                    break;
               
                case 5:
                for (Doctor d : doctors) {
        System.out.println(d.getId() + " - Dr. " + d.getName());
    }

    Doctor selectedDoctorr = null;
    while (selectedDoctorr == null) {
        System.out.print("Enter Doctor ID: ");
        String docId = scanner.nextLine();
        for (Doctor d : doctors) {
            if (d.getId().equals(docId)) {
                selectedDoctorr = d;
                break;
            }
        }
        if (selectedDoctorr == null) {
            System.out.println("Invalid ID. Try again.");
        }
    }
                PanicButton.trigger(patient, selectedDoctorr);
                break;

                case 6:
                System.out.print("Enter Doctor ID: ");
                String docId = scanner.nextLine();
                Doctor targetDoc = findDoctorById(doctors, docId);
                if (targetDoc != null) {
                System.out.print("Enter Message: ");
                String msg = scanner.nextLine();
                ChatServer.sendMessage(patient, targetDoc, msg);
                } else {
                System.out.println("Doctor not found.");
            }
                break;

                case 7:
                ChatServer.showChatHistory();
                break;

                case 8:
                VideoCall.startCall(patient.getName(), "https://zoom.us/j/abc-123");
                break;

               case 9:
               return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    //  DOCTOR LOGIN FUNCTION
    private static void DoctorLogin(
            Scanner scanner, 
            ArrayList<Doctor> doctors, 
            ArrayList<Patient> patients,
            ArrayList<Appointment> appointments) {
        System.out.print("\nEnter Doctor ID: ");
        String id = scanner.nextLine();

        Doctor doctor = findDoctorById(doctors, id);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        while (true) {
            System.out.println("\n[Doctor Menu]");
            System.out.println("[1] View Appointments");
            System.out.println("[2] Provide Feedback to a Patient");
            System.out.println("[3] View Chat History");
            System.out.println("[4] Start Video Call");
            System.out.println("[5] Send Reminder to Patient");
            System.out.println("[6] Exit Doctor Menu");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    for(Appointment a: appointments){
                        if(a.getDoctor().equals(doctor.getId())){
                            a.displayAppointment();
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    Patient patient = findPatientByName(patients, patientName);
                    if (patient != null) {
                        System.out.print("Enter Feedback: ");
                        String feedback = scanner.nextLine();
                        doctor.provideFeedback(patient, feedback);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3:
                   ChatServer.showChatHistory();
                   break;

                case 4:
                    VideoCall.startCall(doctor.getName(), "https://meet.google.com/xyz-abc");
                    break;

                case 5:
                System.out.print("Enter Patient Email: ");
                String patientEmail = scanner.nextLine();

                System.out.print("Enter Reminder Message: ");
                String reminderMsg = scanner.nextLine();

               Notifyable emailNotifier = new EmailNotification();
               ReminderService reminderService = new ReminderService(emailNotifier);

   
               emailNotifier.sendNotification(patientEmail, reminderMsg);
                break;

                    
                case 6:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    //  ADMIN LOGIN FUNCTION
    private static void AdministratorLogin(Scanner scanner, Administrator admin, ArrayList<Patient> patients, ArrayList<Doctor> doctors) {
        System.out.println("\n[Administrator Menu]");
        EmailNotification emailNotifier = new EmailNotification();

        while (true) {
            System.out.println("[1] Add a New Doctor");
            System.out.println("[2] Add a New Patient");
            System.out.println("[3] View System Logs");
            System.out.println("[4] View Doctors");
            System.out.println("[5] View Patients");
            System.out.println("[6] Send Email Notification");
            System.out.println("[7] Exit Admin Menu");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewDoctor(scanner, admin);
                    break;
                case 2:
                    addNewPatient(scanner, admin);
                    break;
                case 3:
                    admin.viewSystemLogs();
                    break;
                case 4:
                    admin.viewDoctors();
                    break;
                case 5:
                    admin.viewPatients();
                    break;
                case 6:
                sendCustomEmail(scanner, emailNotifier);
                break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    private static void addNewDoctor(Scanner scanner, Administrator admin) {
    System.out.print("Enter Doctor Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Doctor Email: ");
    String email = scanner.nextLine();
    System.out.print("Enter Doctor ID: ");
    String id = scanner.nextLine();
    System.out.print("Enter Specialization: ");
    String specialization = scanner.nextLine();

    Doctor newDoctor = new Doctor(name, email, id, specialization);
    admin.addDoctor(newDoctor); 
    }
    private static void addNewPatient(Scanner scanner, Administrator admin) {
    System.out.print("Enter Patient Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Patient Email: ");
    String email = scanner.nextLine();
    System.out.print("Enter Patient ID: ");
    String id = scanner.nextLine();

    Patient newPatient = new Patient(name, email, id);
    admin.addPatient(newPatient);  // Calling the method to add the patient
}
    private static void sendCustomEmail(Scanner scanner, EmailNotification emailNotifier) {
    System.out.print("Enter recipient's email address: ");
    String to = scanner.nextLine();
    System.out.print("Enter message to send: ");
    String message = scanner.nextLine();

    emailNotifier.sendNotification(to, message);
}


    //  APPOINTMENT MANAGER FUNCTION
    private static void AppointmentManagerLogin(
            Scanner scanner, 
            AppointmentManager manager,
            ArrayList<Doctor> doctors,
            ArrayList<Patient> patients,
            ArrayList<Appointment> appointments) {
        while (true) {
            System.out.println("\n[Appointment Manager]");
            System.out.println("[1] View Appointments");
            System.out.println("[2] Exit Appointment Manager");
            System.out.println("[3] Approve an Appointment");
            System.out.println("[4] Reject an Appointment");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            ArrayList<String> doctorIds = new ArrayList();
            for(Doctor d: doctors){
                doctorIds.add(d.getId());
            }
            ArrayList<String> patientIds = new ArrayList();
            for(Patient p: patients){
                patientIds.add(p.getId());
            }
            String doctorId;
            String patientId;
            switch (choice) {
                case 1:
                    manager.displayAppointments();
                    break;
                case 2:
                    return;
                case 3:
                    do{
                        for(String identity: doctorIds){
                            System.out.println(identity);
                        }
                        System.out.println("Pick a Doctor Id");
                        doctorId = scanner.nextLine();
                    } while(!doctorIds.contains(doctorId));
                    System.out.println("\n\n\n");
                    do{
                        for(String identity: patientIds){
                            System.out.println(identity);
                        }
                        System.out.println("Pick a Patient Id");
                        patientId = scanner.nextLine();
                    } while(!patientIds.contains(patientId));
                    manager.setAppointments(appointments);
                    Appointment appointmentToApprove = manager.findAppointment(
                            patientId, 
                            doctorId);
                    if (appointmentToApprove != null) {
                        manager.approveAppointment(appointmentToApprove);
                    } else {
                        System.out.println("Appointment not found.");
                    }
                break;
                case 4:
                    do{
                        for(String identity: doctorIds){
                            System.out.println(identity);
                        }
                        System.out.println("Pick a Doctor Id");
                        doctorId = scanner.nextLine();
                    } while(!doctorIds.contains(doctorId));
                    System.out.println("\n\n\n");
                    do{
                        for(String identity: patientIds){
                            System.out.println(identity);
                        }
                        System.out.println("Pick a Patient Id");
                        patientId = scanner.nextLine();
                    } while(!patientIds.contains(patientId));
                    manager.setAppointments(appointments);
                    Appointment appointmentToReject = manager.findAppointment(patientId, doctorId);
                    if (appointmentToReject != null) {
                        manager.rejectAppointment(appointmentToReject);
                    } else {
                        System.out.println("Appointment not found.");
                    }
                break;
                default:
                    System.out.println("Invalid option.");
                            
            }
        }
    }

    // HELPER METHODS FOR LOOKUP
    private static Patient findPatientById(ArrayList<Patient> patients, String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(ArrayList<Doctor> doctors, String id) {
        for (Doctor d : doctors) {
            if (d.getId().equals(id)) return d;
        }
        return null;
    }

    private static Patient findPatientByName(ArrayList<Patient> patients, String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) return p;
        }
        return null;
    }
    
}
