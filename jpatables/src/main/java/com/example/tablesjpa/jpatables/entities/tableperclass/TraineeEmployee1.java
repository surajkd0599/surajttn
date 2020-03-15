package com.example.tablesjpa.jpatables.entities.tableperclass;

import javax.persistence.Entity;

@Entity
public class TraineeEmployee1 extends Employee{
    private String assessmentScore;

    public String getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(String assessmentScore) {
        this.assessmentScore = assessmentScore;
    }
}
