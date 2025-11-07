package com.code.november;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String gender;
    private double salary;
    private int age;
    private String subject;
    private double marks;

    public Employee(int id, String name, String department, String gender, double salary, int age, String subject, double marks) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
        this.subject = subject;
        this.marks = marks;
    }

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

//    public Employee(String alice, String hr, int salary, int age, String female) {
//    }


    public Employee(int id,String name, String department, double salary, int age, String gender) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
        this.age = age;
        this.id = id;
    }

    // --- Getters ---
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getGender() { return gender; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public String getSubject() { return subject; }
    public double getMarks() { return marks; }

    // --- Setters (optional) ---
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setGender(String gender) { this.gender = gender; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setAge(int age) { this.age = age; }
    public void setSubject(String subject) { this.subject = subject; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return String.format("%s(%s, %.2f)", name, department, salary);
    }
}

