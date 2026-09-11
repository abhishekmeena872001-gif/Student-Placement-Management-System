package com.abhishek.placement;

public class Company {
    private int id;
    private String name;
    private double minimumPercentage;
    private String role;

    public Company(int id, String name, double minimumPercentage, String role) {
        this.id = id;
        this.name = name;
        this.minimumPercentage = minimumPercentage;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMinimumPercentage() { return minimumPercentage; }
    public String getRole() { return role; }

    @Override
    public String toString() {
        return String.format("%-4d %-20s %-12.2f %-25s", id, name, minimumPercentage, role);
    }
}
