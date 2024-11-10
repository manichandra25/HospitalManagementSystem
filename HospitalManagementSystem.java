import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String id;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

class Appointment {
    private String patientId;
    private String doctor;
    private String date;

    public Appointment(String patientId, String doctor, String date) {
        this.patientId = patientId;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Doctor: " + doctor + ", Date: " + date;
    }
}

public class HospitalManagementSystem {
    private List<Patient> patients;
    private List<Appointment> appointments;
    private Scanner scanner;

    public HospitalManagementSystem() {
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addPatient() {
        System.out.print("Enter patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = Integer.parseInt(scanner.nextLine());

        Patient patient = new Patient(id, name, age);
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }

    public void scheduleAppointment() {
        System.out.print("Enter patient ID: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter doctor's name: ");
        String doctor = scanner.nextLine();
        System.out.print("Enter appointment date: ");
        String date = scanner.nextLine();

        Appointment appointment = new Appointment(patientId, doctor, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }

    public void displayPatients() {
        System.out.println("\nList of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void displayAppointments() {
        System.out.println("\nList of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\nHospital Management System Menu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Display Patients");
            System.out.println("4. Display Appointments");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    displayPatients();
                    break;
                case 4:
                    displayAppointments();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem hospitalSystem = new HospitalManagementSystem();
        hospitalSystem.mainMenu();
    }
}
