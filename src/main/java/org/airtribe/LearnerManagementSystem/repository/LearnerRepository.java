package org.airtribe.LearnerManagementSystem.repository;

import org.airtribe.LearnerManagementSystem.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {

}
