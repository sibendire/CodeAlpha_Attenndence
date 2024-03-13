package com.attendance.attendence.resourcecontroller;

import com.attendance.attendence.attendenceservice.StudentService;
import com.attendance.attendence.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class ResourceController {
    private final StudentService studentService;

    public ResourceController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String showPage() {
        return "welcome";
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveNewStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student saves successfully");
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> showAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(students);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudentRecordById(@PathVariable("id") Long id,Student student) {
        boolean updated = studentService.updateStudentById(id,student );
        if (updated) {
            return ResponseEntity.ok("The records have been updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentRecord(Long id) {
        boolean delete = studentService.deleteById(id);
        if (delete) {
            return ResponseEntity.ok("The records have been deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
