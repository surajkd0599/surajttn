package com.example.tablesjpa.jpatables.entities.joinedtable;

import javax.persistence.Entity;

@Entity
public class RegularEmployee2 extends EmployeeJoined {
    private String project;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
