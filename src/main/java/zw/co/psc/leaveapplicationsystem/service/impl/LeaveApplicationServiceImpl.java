package zw.co.psc.leaveapplicationsystem.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.psc.leaveapplicationsystem.exception.ResourceNotFoundException;
import zw.co.psc.leaveapplicationsystem.domain.LeaveApplication;
import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveStatus;
import zw.co.psc.leaveapplicationsystem.persistence.LeaveApplicationRepository;
import zw.co.psc.leaveapplicationsystem.service.EmailNotificationService;
import zw.co.psc.leaveapplicationsystem.service.LeaveApplicationService;
import zw.co.psc.leaveapplicationsystem.service.dto.LeaveApplicationDTO;
import zw.co.psc.leaveapplicationsystem.service.dto.LeaveApplicationRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveApplicationServiceImpl implements LeaveApplicationService {
    private final LeaveApplicationRepository leaveRepository;
    private final EmailNotificationService emailService;

    @Autowired
    public LeaveApplicationServiceImpl(LeaveApplicationRepository leaveRepository, EmailNotificationService emailService) {
        this.leaveRepository = leaveRepository;
        this.emailService = emailService;
    }

    @Override
    public LeaveApplication createLeaveApplication(LeaveApplicationRequest request) {
        LeaveApplication leave = new LeaveApplication(request);
        leave.setStatus(LeaveStatus.PENDING);
        LeaveApplication savedLeave = leaveRepository.save(leave);

        emailService.sendLeaveSubmissionNotification(savedLeave);
        return savedLeave;
    }

    @Override
    public LeaveApplication updateLeaveStatus(Long leaveId, LeaveStatus status) {
        LeaveApplication leave = leaveRepository.findById(leaveId)
                .orElseThrow(() -> new ResourceNotFoundException("Leave Application not found"));

        leave.setStatus(status);
        leave.setUpdatedAt(LocalDateTime.now());
        LeaveApplication updatedLeave = leaveRepository.save(leave);

        emailService.sendStatusUpdateNotification(updatedLeave);
        return updatedLeave;
    }

    @Override
    public List<LeaveApplicationDTO> getAllLeavesForEmployee(Long employeeId) {
        return leaveRepository.findByEmployeeId(employeeId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public LeaveApplicationDTO cancelLeave(Long leaveApplicationId) {
        LeaveApplication leaveApplication = leaveRepository.findById(leaveApplicationId)
                .orElseThrow(() -> new IllegalArgumentException("Leave application not found"));

        if (leaveApplication.getStatus() != LeaveStatus.PENDING) {
            throw new IllegalStateException("Only pending leaves can be canceled");
        }

        leaveApplication.setStatus(LeaveStatus.CANCELED);
        leaveRepository.save(leaveApplication);

        return mapToDTO(leaveApplication);
    }
    @Override
    public List<LeaveApplicationDTO> getAllPendingLeaveApplications() {
        List<LeaveApplication> pendingLeaveApplications = leaveRepository.findByStatus(LeaveStatus.PENDING);
        return pendingLeaveApplications.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LeaveApplicationDTO mapToDTO(LeaveApplication leaveApplication) {
        return new LeaveApplicationDTO(
                leaveApplication.getId(),
                leaveApplication.getEmployee().getId(),
                leaveApplication.getStartDate(),
                leaveApplication.getEndDate(),
                leaveApplication.getLeaveType(),
                leaveApplication.getStatus()
        );
    }
}

