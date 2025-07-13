package com.cognizant.spring_rest_handson.model;

public class Employee {
    private int id;
    private String name;
    private Department department;
    private Skill skill;

    public Employee() {}

    public Employee(int id, String name, Department department, Skill skill) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.skill = skill;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
}
