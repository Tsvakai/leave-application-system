package zw.co.psc.leaveapplicationsystem.service;

import zw.co.psc.leaveapplicationsystem.domain.LeaveApplication;
import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveStatus;
import zw.co.psc.leaveapplicationsystem.service.dto.LeaveApplicationDTO;
import zw.co.psc.leaveapplicationsystem.service.dto.LeaveApplicationRequest;

import java.util.List;

public interface LeaveApplicationService {
    LeaveApplication createLeaveApplication(LeaveApplicationRequest request);
    LeaveApplication updateLeaveStatus(Long leaveId, LeaveStatus status);
    List<LeaveApplicationDTO> getAllLeavesForEmployee(Long employeeId);
    LeaveApplicationDTO cancelLeave(Long leaveApplicationId);
    List<LeaveApplicationDTO> getAllPendingLeaveApplications();
}
