package org.airtribe.LearnerManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long learnerId;

    private String learnerName;

    private String learnerEmail;

    public Learner() {

    }

    public Learner(long learnerId, String learnerName, String learnerEmail) {
        this.learnerId = learnerId;
        this.learnerName = learnerName;
        this.learnerEmail = learnerEmail;
    }

    public long getLearnerId() {
        return learnerId;
    }

    public String getLearnerName() {
        return learnerName;
    }

    public String getLearnerEmail() {
        return learnerEmail;
    }

    public void setLearnerId(long learnerId) {
        this.learnerId = learnerId;
    }

    public void setLearnerName(String learnerName) {
        this.learnerName = learnerName;
    }

    public void setLearnerEmail(String learnerEmail) {
        this.learnerEmail = learnerEmail;
    }
}


// this must be standard use case
// Connection to external Database
// translation -> database understands
// Querying
// CRUD Operations for the Data