package com.attendance.attendence.attendenceservice.serviceimpl;

import com.attendance.attendence.attendencerepository.AttendanceRecordsRepository;
import com.attendance.attendence.attendenceservice.AttendanceRecordsService;
import com.attendance.attendence.entity.AttendanceRecords;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AttendanceRecordsServiceImpl implements AttendanceRecordsService {

private final AttendanceRecordsRepository attendanceRecordsRepository;

    public AttendanceRecordsServiceImpl(AttendanceRecordsRepository attendanceRecordsRepository) {
        this.attendanceRecordsRepository = attendanceRecordsRepository;
    }


    @Override
    public List<AttendanceRecords> getAllAttendanceRecord() {
        return attendanceRecordsRepository.findAll();
    }

    @Override
    public AttendanceRecords getAttendanceRecordsById(Long id) {
        return null;
    }

    @Override
    public void saveAttendanceRecords(AttendanceRecords attendanceRecords) {

    }

    @Override
    public boolean deleteAttendanceRecordsById(Long id) {
        return false;
    }
}
