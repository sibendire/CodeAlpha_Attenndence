package com.attendance.attendence.attendenceservice.serviceimpl;

import com.attendance.attendence.attendencerepository.CourseRepository;
import com.attendance.attendence.attendenceservice.CourseService;
import com.attendance.attendence.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public boolean updateCourseById(Long id, Course course) {
        if (!courseRepository.existsById(id)) {
            return false;
        }
        course.setId(id);
        courseRepository.save(course);
        return true;
    }

    @Override
    public boolean deleteCourseById(Long id) {
        if (!courseRepository.existsById(id)) {
            return false;
        }
        courseRepository.deleteById(id);
        return true;
    }
}
