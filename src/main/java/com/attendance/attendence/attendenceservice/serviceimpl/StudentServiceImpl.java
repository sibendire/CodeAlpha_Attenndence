package com.attendance.attendence.attendenceservice.serviceimpl;

import com.attendance.attendence.attendencerepository.StudentRepository;
import com.attendance.attendence.attendenceservice.StudentService;
import com.attendance.attendence.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Object saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean updateStudentById(Long id, Student student) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        student.setId(id);
        studentRepository.save(student);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
