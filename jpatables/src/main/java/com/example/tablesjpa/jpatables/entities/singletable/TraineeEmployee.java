package com.example.tablesjpa.jpatables.entities.singletable;

import com.example.tablesjpa.jpatables.entities.singletable.EmployeeSingle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("trainee_employee")
public class TraineeEmployee extends EmployeeSingle {
    private String assessmentScore;

    public String getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(String assessmentScore) {
        this.assessmentScore = assessmentScore;
    }
}
