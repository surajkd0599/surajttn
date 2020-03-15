package com.example.tablesjpa.jpatables.entities.joinedtable;

import javax.persistence.Entity;

@Entity
public class TraineeEmployee2 extends EmployeeJoined {
    private String assessmentScore;

    public String getAssessmentScore() {
        return assessmentScore;
    }

    public void setAssessmentScore(String assessmentScore) {
        this.assessmentScore = assessmentScore;
    }
}
