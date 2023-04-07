package com.courseoffering.service;

import com.courseoffering.entity.CourseOffering;
import org.springframework.stereotype.Service;


@Service
public interface CourseOfferingService {
    CourseOffering findById(Long id);
    void save(CourseOffering courseOffering);
    void cancelCourseOffering(Long id);
}