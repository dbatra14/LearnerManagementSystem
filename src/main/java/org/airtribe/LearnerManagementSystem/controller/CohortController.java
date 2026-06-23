package org.airtribe.LearnerManagementSystem.controller;

import org.airtribe.LearnerManagementSystem.entity.Cohort;
import org.airtribe.LearnerManagementSystem.entity.Learner;
import org.airtribe.LearnerManagementSystem.exception.CohortNotFoundException;
import org.airtribe.LearnerManagementSystem.exception.LearnrNotFoundException;
import org.airtribe.LearnerManagementSystem.service.CohortManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CohortController {

    @Autowired
    private CohortManagementService cohortManagementService;

    @PostMapping("/cohorts")
    public Cohort createCohort(@RequestBody Cohort cohort)
    {
        return cohortManagementService.createCohort(cohort);
    }

    @PostMapping("/assignLearnersToCohorts")
    public Cohort assignLearnerToCohorts(@RequestParam ("cohortId") Long cohortId,
                                         @RequestParam ("learnerId") Long learnerId) throws CohortNotFoundException, LearnrNotFoundException {
        return cohortManagementService.assignLearnerToCohort(cohortId,learnerId);
    }

    @ExceptionHandler(CohortNotFoundException.class)
    public ResponseEntity handleCohortNotFoundException(CohortNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(LearnrNotFoundException.class)
    public ResponseEntity handleLearnerNotFoundException(LearnrNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
    // We take ID

}
