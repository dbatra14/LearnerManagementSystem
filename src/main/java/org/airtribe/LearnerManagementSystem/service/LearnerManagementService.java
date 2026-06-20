package org.airtribe.LearnerManagementSystem.service;

import org.airtribe.LearnerManagementSystem.entity.Learner;
import org.airtribe.LearnerManagementSystem.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerManagementService {

    @Autowired
    private LearnerRepository _learnerRepository;

    public Learner createLearner(Learner learner)
    {
        return _learnerRepository.save(learner);
    }
}
