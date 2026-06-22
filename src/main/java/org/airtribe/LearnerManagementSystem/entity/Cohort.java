package org.airtribe.LearnerManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
public class Cohort {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long cohortId;

    private String cohortName;

    private String cohortDescription;

    @ManyToMany
    private List<Learner> learners;

    public Cohort() {

    }

    public Cohort(Long cohortId, String cohortName, String cohortDescription, List<Learner> learners) {
        this.cohortId = cohortId;
        this.cohortName = cohortName;
        this.cohortDescription = cohortDescription;
        this.learners = learners;
    }

    public Long getCohortId() {
        return cohortId;
    }

    public String getCohortName() {
        return cohortName;
    }

    public String getCohortDescription() {
        return cohortDescription;
    }

    public List<Learner> getLearners() {
        return learners;
    }

    public void setCohortId(Long cohortId) {
        this.cohortId = cohortId;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }

    public void setCohortDescription(String cohortDescription) {
        this.cohortDescription = cohortDescription;
    }

    public void setLearners(List<Learner> learners) {
        this.learners = learners;
    }
}
