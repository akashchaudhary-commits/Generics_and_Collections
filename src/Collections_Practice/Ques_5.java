package Collections_Practice;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;

abstract class Patient {
    protected String patientId;
    protected String name;
    protected double baseConsultationFee;

    public Patient(String patientId, String name, double baseConsultationFee) {
        this.patientId = patientId;
        this.name = name;
        this.baseConsultationFee = baseConsultationFee;
    }

    public abstract double calculateTotalBill();

    public String getSummary() {
        return String.format("%s | %s | Bill: %.2f", patientId, name, calculateTotalBill());
    }
}

class EmergencyPatient extends Patient {
    private double traumaSurcharge;

    public EmergencyPatient(String patientId, String name, double baseConsultationFee, double traumaSurcharge) {
        super(patientId, name, baseConsultationFee);
        this.traumaSurcharge = traumaSurcharge;
    }

    @Override
    public double calculateTotalBill() {
        return baseConsultationFee + traumaSurcharge;
    }
}

class RegularPatient extends Patient {
    private double discountPercent;

    public RegularPatient(String patientId, String name, double baseConsultationFee, double discountPercent) {
        super(patientId, name, baseConsultationFee);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateTotalBill() {
        return baseConsultationFee - (baseConsultationFee * discountPercent / 100.0);
    }
}

class TriageQueue {
    private LinkedList<Patient> queue = new LinkedList<>();

    public void admitPatient(Patient p) {
        if (p instanceof EmergencyPatient) {
            queue.addFirst(p);
        } else {
            queue.addLast(p);
        }
    }

    public void treatNextPatient() {
        Patient next = queue.pollFirst();
        if (next != null) {
            System.out.println("Treated: " + next.getSummary());
        }
    }

    public void displayRemainingReverse() {
        System.out.println("--- Waiting Queue (Reverse) ---");
        Iterator<Patient> descIt = queue.descendingIterator();
        while (descIt.hasNext()) {
            System.out.println(descIt.next().getSummary());
        }
    }
}

public class Ques_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        TriageQueue triage = new TriageQueue();

        for (int i = 0; i < n; i++) {
            String type = scanner.nextLine().trim().toUpperCase();
            String id = scanner.nextLine().trim();
            String name = scanner.nextLine().trim();
            double fee = Double.parseDouble(scanner.nextLine().trim());

            if (type.equals("EMERGENCY")) {
                double surcharge = Double.parseDouble(scanner.nextLine().trim());
                triage.admitPatient(new EmergencyPatient(id, name, fee, surcharge));
            } else if (type.equals("REGULAR")) {
                double discount = Double.parseDouble(scanner.nextLine().trim());
                triage.admitPatient(new RegularPatient(id, name, fee, discount));
            }
        }

        int k = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < k; i++) {
            triage.treatNextPatient();
        }

        triage.displayRemainingReverse();
        scanner.close();
    }
}

