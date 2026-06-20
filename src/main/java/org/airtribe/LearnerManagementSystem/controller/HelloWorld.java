package org.airtribe.LearnerManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World Test";
    }

    // Resources

    /*
    "/learners" -> GET, POST, PUT, DELETE
    // http://localhost:8080/learners

     */

    /*
    learner {
    Name
    Cohort
     */


    // /cohorts
    // /courses
    // /instructors

    /*
    Question -> Fetch all learners of cohort 1
        /learner?cohortId=1;
        /cohort/1/learners
     */

}
