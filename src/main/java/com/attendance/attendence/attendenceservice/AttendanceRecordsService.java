package com.attendance.attendence.attendenceservice;

import com.attendance.attendence.entity.AttendanceRecords;

import java.util.List;

public interface AttendanceRecordsService {
    List<AttendanceRecords> getAllAttendanceRecord();

    AttendanceRecords getAttendanceRecordsById(Long id);

    void saveAttendanceRecords(AttendanceRecords attendanceRecords);

    boolean deleteAttendanceRecordsById(Long id);
}
