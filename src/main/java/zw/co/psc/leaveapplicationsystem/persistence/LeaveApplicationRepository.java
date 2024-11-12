package zw.co.psc.leaveapplicationsystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.psc.leaveapplicationsystem.domain.LeaveApplication;
import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveStatus;

import java.util.List;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {
    List<LeaveApplication> findByEmployeeId(Long employeeId);

    List<LeaveApplication> findByStatus(LeaveStatus leaveStatus);
}

