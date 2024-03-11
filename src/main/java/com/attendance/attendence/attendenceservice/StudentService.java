package com.attendance.attendence.attendenceservice;

import com.attendance.attendence.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional getStudentById(Long id);
    Object saveStudent(Student student);
    boolean updateStudentById(Long id,Student student);
    boolean deleteById(Long id);
}
