package com.abhishek.placement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlacementManager {
    private final List<Student> students = new ArrayList<>();
    private final List<Company> companies = new ArrayList<>();

    public void addStudent(Student student) { students.add(student); }
    public void addCompany(Company company) { companies.add(company); }

    public List<Student> getStudents() { return students; }
    public List<Company> getCompanies() { return companies; }

    public List<Student> searchStudent(String keyword) {
        List<Student> result = new ArrayList<>();
        String key = keyword.toLowerCase();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(key)
                    || student.getBranch().toLowerCase().contains(key)) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortStudentsByPercentage() {
        students.sort(Comparator.comparingDouble(Student::getPercentage).reversed());
    }

    public List<Student> eligibleStudents(Company company) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (!student.isPlaced() && student.getPercentage() >= company.getMinimumPercentage()) {
                result.add(student);
            }
        }
        return result;
    }

    public boolean markPlaced(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                student.setPlaced(true);
                return true;
            }
        }
        return false;
    }
}
