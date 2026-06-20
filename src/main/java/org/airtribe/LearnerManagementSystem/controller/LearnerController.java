package org.airtribe.LearnerManagementSystem.controller;

import org.airtribe.LearnerManagementSystem.entity.Learner;
import org.airtribe.LearnerManagementSystem.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LearnerController {

    @Autowired
    private LearnerManagementService learnerManagementService;

    // Jackson - Serialisation
    @PostMapping("/learner")
    public Learner createLearner(@RequestBody Learner learner)
    {
        return learnerManagementService.createLearner(learner);
    }
}
