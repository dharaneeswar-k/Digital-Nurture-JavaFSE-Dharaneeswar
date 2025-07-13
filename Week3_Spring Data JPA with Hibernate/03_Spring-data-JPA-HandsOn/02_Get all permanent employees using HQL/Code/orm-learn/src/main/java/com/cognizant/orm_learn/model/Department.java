package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "dp_id")
    private int id;

    @Column(name = "dp_name")
    private String name;

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "'}";
    }

}
