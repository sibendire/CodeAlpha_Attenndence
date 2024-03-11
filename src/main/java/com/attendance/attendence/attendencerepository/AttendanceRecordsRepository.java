package com.attendance.attendence.attendencerepository;

import com.attendance.attendence.entity.AttendanceRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRecordsRepository extends JpaRepository<AttendanceRecords,Long> {
}
