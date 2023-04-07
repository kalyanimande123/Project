package com.courseoffering.controller;

import com.courseoffering.entity.CourseOffering;
import com.courseoffering.entity.Employee;
import com.courseoffering.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course-offerings")
public class CourseOfferingController {


    @Autowired
     CourseOfferingService courseOfferingService;

//    @Autowired
//    public CourseOfferingController(CourseOfferingService courseOfferingService) {
//        this.courseOfferingService = courseOfferingService;
//    }

    // endpoint for registering an employee to a course offering
    @PostMapping("/{id}/register")
    public ResponseEntity<String> registerEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        CourseOffering courseOffering = courseOfferingService.findById(id);
        if (courseOffering == null) {
            return ResponseEntity.notFound().build();
        }

        String result = courseOffering.registerEmployee(employee);
        if (result.equals("COURSE_FULL_ERROR")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course is full, registration not accepted.");
        } else {
            courseOfferingService.save(courseOffering);
            return ResponseEntity.ok("Employee registered for course.");
        }
    }

    // endpoint for cancelling a registration
    @PostMapping("/{id}/cancel")
    public ResponseEntity<String> cancelRegistration(@PathVariable Long id, @RequestBody Employee employee) {
        CourseOffering courseOffering = courseOfferingService.findById(id);
        if (courseOffering == null) {
            return ResponseEntity.notFound().build();
        }

        String result = courseOffering.cancelRegistration(employee);
        if (result.equals("ALREADY_ALLOTTED_ERROR")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration cannot be cancelled, employee has already been allotted to course.");
        } else if (result.equals("NOT_REGISTERED_ERROR")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee has not registered for course.");
        } else {
            courseOfferingService.save(courseOffering);
            return ResponseEntity.ok("Registration cancelled successfully.");
        }
    }

    // endpoint for allotting employees to a course offering
    @PostMapping("/{id}/allot")
    public ResponseEntity<String> allotEmployees(@PathVariable Long id) {
        CourseOffering courseOffering = courseOfferingService.findById(id);
        if (courseOffering == null) {
            return ResponseEntity.notFound().build();
        }

        courseOffering.allotEmployees();
        courseOfferingService.save(courseOffering);
        return ResponseEntity.ok("Employees allotted to course offering.");
    }
}
