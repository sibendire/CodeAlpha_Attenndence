package com.attendance.attendence.resourcecontroller;

import com.attendance.attendence.attendenceservice.CourseService;
import com.attendance.attendence.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/saveCourse")
    public ResponseEntity<String> saveNewCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course saves successfully");
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
        Optional<Course> course = courseService.getCourseById(id);
        if (course.isPresent()) {
            return ResponseEntity.ok(course.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> showAllCourse() {
        List<Course> courses = courseService.getAllCourse();
        if (courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(courses);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourseRecordById(@PathVariable("id") Long id, Course course) {
        boolean updated = courseService.updateCourseById(id, course);
        if (updated) {
            return ResponseEntity.ok("The records have been updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/course/{id}")
    public ResponseEntity<String> deleteCourseRecord(@PathVariable("id") Long id) {
        boolean delete = courseService.deleteCourseById(id);
        if (delete) {
            return ResponseEntity.ok("The records have been deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
