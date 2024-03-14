package com.attendance.attendence.attendenceservice.serviceimpl;

import com.attendance.attendence.attendencerepository.AttendanceRecordsRepository;
import com.attendance.attendence.attendenceservice.AttendanceRecordsService;
import com.attendance.attendence.entity.AttendanceRecords;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<AttendanceRecords> getAttendanceRecordsById(Long id) {
        return attendanceRecordsRepository.findById(id);

    }

    @Override
    public void saveAttendanceRecords(AttendanceRecords attendanceRecords) {
          attendanceRecordsRepository.save(attendanceRecords);
    }

    @Override
    public boolean updateAttendanceRecordsById(Long id, AttendanceRecords attendanceRecords) {
        if (!attendanceRecordsRepository.existsById(id)){
            return false;
        }
        attendanceRecords.setId(id);
        attendanceRecordsRepository.save(attendanceRecords);
        return true;
    }

    @Override
    public boolean deleteAttendanceRecordsById(Long id) {
        if (!attendanceRecordsRepository.existsById(id))
        return false;
        attendanceRecordsRepository.deleteById(id);
        return true;
    }

}
