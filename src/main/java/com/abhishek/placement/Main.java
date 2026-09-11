package com.abhishek.placement;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PlacementManager manager = new PlacementManager();

    public static void main(String[] args) {
        loadSampleData();
        System.out.println("==============================================");
        System.out.println("   STUDENT PLACEMENT MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> addStudent();
                case "2" -> addCompany();
                case "3" -> showStudents(manager.getStudents());
                case "4" -> showCompanies();
                case "5" -> searchStudents();
                case "6" -> showEligibleStudents();
                case "7" -> markStudentPlaced();
                case "8" -> {
                    manager.sortStudentsByPercentage();
                    System.out.println("Students sorted by percentage (highest first).");
                }
                case "0" -> {
                    System.out.println("Thank you for using the system!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. Add Company");
        System.out.println("3. View Students");
        System.out.println("4. View Companies");
        System.out.println("5. Search Student");
        System.out.println("6. Check Eligibility");
        System.out.println("7. Mark Student Placed");
        System.out.println("8. Sort Students by Percentage");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addStudent() {
        try {
            System.out.print("Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Branch: ");
            String branch = scanner.nextLine();
            System.out.print("Percentage: ");
            double percentage = Double.parseDouble(scanner.nextLine());
            manager.addStudent(new Student(id, name, branch, percentage));
            System.out.println("Student added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        }
    }

    private static void addCompany() {
        try {
            System.out.print("Company ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Company name: ");
            String name = scanner.nextLine();
            System.out.print("Minimum percentage: ");
            double minimum = Double.parseDouble(scanner.nextLine());
            System.out.print("Job role: ");
            String role = scanner.nextLine();
            manager.addCompany(new Company(id, name, minimum, role));
            System.out.println("Company added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
        }
    }

    private static void showStudents(List<Student> students) {
        System.out.println("\nID   Name                 Branch       Percentage Placed");
        System.out.println("----------------------------------------------------------");
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    private static void showCompanies() {
        System.out.println("\nID   Company              Min %        Role");
        System.out.println("--------------------------------------------------------------");
        if (manager.getCompanies().isEmpty()) {
            System.out.println("No companies found.");
            return;
        }
        manager.getCompanies().forEach(System.out::println);
    }

    private static void searchStudents() {
        System.out.print("Enter name or branch keyword: ");
        String keyword = scanner.nextLine();
        showStudents(manager.searchStudent(keyword));
    }

    private static void showEligibleStudents() {
        showCompanies();
        System.out.print("Enter company ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            for (Company company : manager.getCompanies()) {
                if (company.getId() == id) {
                    System.out.println("\nEligible students for " + company.getName() + ":");
                    showStudents(manager.eligibleStudents(company));
                    return;
                }
            }
            System.out.println("Company not found.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid company ID.");
        }
    }

    private static void markStudentPlaced() {
        System.out.print("Enter student ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println(manager.markPlaced(id) ? "Student marked as placed." : "Student not found.");
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid student ID.");
        }
    }

    private static void loadSampleData() {
        manager.addStudent(new Student(101, "Aarav Sharma", "CSE", 82.5));
        manager.addStudent(new Student(102, "Priya Verma", "AIML", 88.0));
        manager.addStudent(new Student(103, "Rohit Singh", "IT", 74.5));
        manager.addCompany(new Company(1, "TechNova", 75.0, "Java Developer"));
        manager.addCompany(new Company(2, "DataWorks", 80.0, "Software Engineer"));
    }
}
