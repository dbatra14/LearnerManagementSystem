package org.airtribe.LearnerManagementSystem.service;

import org.airtribe.LearnerManagementSystem.entity.Learner;
import org.airtribe.LearnerManagementSystem.exception.LearnrNotFoundException;
import org.airtribe.LearnerManagementSystem.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerManagementService {

    @Autowired
    private LearnerRepository _learnerRepository;

    public Learner createLearner(Learner learner)
    {
        return _learnerRepository.save(learner);
    }

    public List<Learner> getAllLearners() {
        return _learnerRepository.findAll();
    }

    public Learner fetchLearnerById(Long learnerId) throws LearnrNotFoundException {
        if(_learnerRepository.findById(learnerId).isPresent()){
            return _learnerRepository.findById(learnerId).get();
        }
        throw new LearnrNotFoundException("Learner with ID" + learnerId + "not found");
    }

    public Learner findLearnerByName(String learnerName) {
        return _learnerRepository.findByLearnerName(learnerName);
    }
}
