package zw.co.psc.leaveapplicationsystem.service.dto;

import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveStatus;
import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveType;

import java.time.LocalDate;

public record LeaveApplicationRequest(Long employeeId, LocalDate startDate, LocalDate endDate, LeaveType leaveType) {}
