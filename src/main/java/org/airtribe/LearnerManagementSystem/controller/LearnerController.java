package org.airtribe.LearnerManagementSystem.controller;

import org.airtribe.LearnerManagementSystem.entity.Learner;
import org.airtribe.LearnerManagementSystem.exception.LearnrNotFoundException;
import org.airtribe.LearnerManagementSystem.service.LearnerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

//    // Fetch the learners
//
//    @GetMapping("/learners")
//    public List<Learner> getAllLearners(){
//        return learnerManagementService.getAllLearners();
//    }
//

//    @GetMapping("/learners/{learnerId}")
//    public Learner getLearnerById(@PathVariable Long learnerId) {
//        return learnerManagementService.fetchLearnerById(learnerId);
//    }
//    // fetch me a learner by learnerId
//    // fetch me a learner by learnerName
//
//    @GetMapping("/leaners/{learnerName}")
//    public Learner getLearnerByName(@PathVariable String learnerName)
//    {
//        return learnerManagementService.findLearnerByName(learnerName);
//    }

    @GetMapping("/learners")
    public List<Learner> findLearnerByComplexParams(@RequestParam(value = "learnerId", required = false) Long learnerId,
                                                    @RequestParam(value = "learnerName", required = false) String learnerName) throws LearnrNotFoundException {
        List<Learner> learners = new ArrayList<>();
        if (learnerId == null && learnerName == null) {
            return learnerManagementService.getAllLearners();
        }
        if (learnerId != null) {
            learners.add(learnerManagementService.fetchLearnerById(learnerId));
        }
        if (learnerName != null) {
            learners.add(learnerManagementService.findLearnerByName(learnerName));
        }
        return learners;
    }

    @ExceptionHandler(LearnrNotFoundException.class)
    public ResponseEntity handleLearnerNotFoundException(LearnrNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
