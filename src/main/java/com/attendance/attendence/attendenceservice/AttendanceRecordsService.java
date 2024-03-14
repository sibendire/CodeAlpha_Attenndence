package com.attendance.attendence.attendenceservice;

import com.attendance.attendence.entity.AttendanceRecords;

import java.util.List;
import java.util.Optional;

public interface AttendanceRecordsService {
    List<AttendanceRecords> getAllAttendanceRecord();

    Optional<AttendanceRecords> getAttendanceRecordsById(Long id);

    void saveAttendanceRecords(AttendanceRecords attendanceRecords);
    boolean updateAttendanceRecordsById(Long id,AttendanceRecords attendanceRecords);

    boolean deleteAttendanceRecordsById(Long id);
}
