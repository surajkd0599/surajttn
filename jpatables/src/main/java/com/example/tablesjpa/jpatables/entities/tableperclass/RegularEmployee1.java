package com.example.tablesjpa.jpatables.entities.tableperclass;

import com.example.tablesjpa.jpatables.entities.tableperclass.Employee;

import javax.persistence.Entity;

@Entity
public class RegularEmployee1 extends Employee {
    private String project;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
