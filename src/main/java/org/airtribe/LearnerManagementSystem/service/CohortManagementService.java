package org.airtribe.LearnerManagementSystem.service;

import org.airtribe.LearnerManagementSystem.entity.Cohort;
import org.airtribe.LearnerManagementSystem.entity.Learner;
import org.airtribe.LearnerManagementSystem.exception.CohortNotFoundException;
import org.airtribe.LearnerManagementSystem.exception.LearnrNotFoundException;
import org.airtribe.LearnerManagementSystem.repository.CohortRepository;
import org.airtribe.LearnerManagementSystem.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CohortManagementService {

    @Autowired
    private CohortRepository _cohortRepository;

    @Autowired
    private LearnerRepository _learnerRepository;

    public Cohort createCohort(Cohort cohort) {
      return _cohortRepository.save(cohort);
    }

    public Cohort assignLearnerToCohort(Long cohortId, Long learnerId) throws CohortNotFoundException, LearnrNotFoundException {
        Optional<Cohort> cohortOptional= _cohortRepository.findById(cohortId);
        if(!cohortOptional.isPresent()){
            throw new CohortNotFoundException("Cannot find cohort with Id" + cohortId);
        }

        List<Learner> learners = cohortOptional.get().getLearners();
        Optional<Learner> learnerOptional = _learnerRepository.findById(learnerId);

        if(!learnerOptional.isPresent()) {
            throw new LearnrNotFoundException("Learner with Id" + learnerId + "not found");
        }
        learners.add(learnerOptional.get());
        _cohortRepository.save(cohortOptional.get());
        return cohortOptional.get();

    }
}
