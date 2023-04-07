package com.courseoffering.serviceImpl;

import com.courseoffering.entity.CourseOffering;
import com.courseoffering.repository.CourseOfferingRepository;
import com.courseoffering.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseOfferingServiceImpl implements CourseOfferingService {

    @Autowired
     CourseOfferingRepository courseOfferingRepository;

//    @Autowired
//    public CourseOfferingServiceImpl(CourseOfferingRepository courseOfferingRepository) {
//        this.courseOfferingRepository = courseOfferingRepository;
//
//    }

    @Override
    public CourseOffering findById(Long id) {

        return  courseOfferingRepository.findById(id).get();

    }

    @Override
    public void save(CourseOffering courseOffering) {

        courseOfferingRepository.save(courseOffering);

    }

    @Override
    public void cancelCourseOffering(Long id) {

        courseOfferingRepository.deleteById(id);

    }
}