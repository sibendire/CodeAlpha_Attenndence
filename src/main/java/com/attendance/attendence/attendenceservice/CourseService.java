package com.attendance.attendence.attendenceservice;

import com.attendance.attendence.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourse();
    Optional<Course> getCourseById(Long id);
    Course saveCourse(Course course);
    boolean updateCourseById(Long id,Course course);
    boolean deleteCourseById(Long id);
}
