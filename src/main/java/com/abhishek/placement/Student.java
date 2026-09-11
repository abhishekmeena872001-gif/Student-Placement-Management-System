package com.abhishek.placement;

public class Student {
    private int id;
    private String name;
    private String branch;
    private double percentage;
    private boolean placed;

    public Student(int id, String name, String branch, double percentage) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.percentage = percentage;
        this.placed = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getBranch() { return branch; }
    public double getPercentage() { return percentage; }
    public boolean isPlaced() { return placed; }
    public void setPlaced(boolean placed) { this.placed = placed; }

    @Override
    public String toString() {
        return String.format("%-4d %-20s %-12s %-10.2f %-10s", id, name, branch, percentage, placed ? "Placed" : "Not Placed");
    }
}
