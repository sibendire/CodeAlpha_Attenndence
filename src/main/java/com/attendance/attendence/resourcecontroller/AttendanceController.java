package com.attendance.attendence.resourcecontroller;

import com.attendance.attendence.attendenceservice.AttendanceRecordsService;
import com.attendance.attendence.entity.AttendanceRecords;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AttendanceController {
    private final AttendanceRecordsService attendanceRecordsService;

    public AttendanceController(AttendanceRecordsService attendanceRecordsService) {
        this.attendanceRecordsService = attendanceRecordsService;
    }


    @PostMapping("/saveAttendance")
    public ResponseEntity<String> saveNewAttendance(@RequestBody AttendanceRecords attendanceRecords) {
        attendanceRecordsService.saveAttendanceRecords(attendanceRecords);
        return ResponseEntity.status(HttpStatus.CREATED).body("Attendance saves successfully");
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<AttendanceRecords> getAttendanceById(@PathVariable("id") Long id) {
        Optional<AttendanceRecords> attendanceRecords = attendanceRecordsService.getAttendanceRecordsById(id);
        if (attendanceRecords.isPresent()) {
            return ResponseEntity.ok(attendanceRecords.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all/attendance")
    public ResponseEntity<List<AttendanceRecords>> showAllAttendanceRecord() {
        List<AttendanceRecords> attendanceRecords = attendanceRecordsService.getAllAttendanceRecord();
        if (attendanceRecords.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(attendanceRecords);
        }
    }

    @PutMapping("/update/attendance/{id}")
    public ResponseEntity<String> updateAttendanceRecordById(@PathVariable("id") Long id, @RequestBody AttendanceRecords attendanceRecords) {
        boolean updated = attendanceRecordsService.updateAttendanceRecordsById(id, attendanceRecords);
        if (updated) {
            return ResponseEntity.ok("The records have been updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/delete/attendance/{id}")
    public ResponseEntity<String> deleteAttendanceRecord(Long id) {
        boolean delete = attendanceRecordsService.deleteAttendanceRecordsById(id);
        if (delete) {
            return ResponseEntity.ok("The records have been deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
