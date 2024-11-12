package zw.co.psc.leaveapplicationsystem.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.psc.leaveapplicationsystem.domain.LeaveApplication;
import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveStatus;
import zw.co.psc.leaveapplicationsystem.service.LeaveApplicationService;
import zw.co.psc.leaveapplicationsystem.service.dto.LeaveApplicationDTO;
import zw.co.psc.leaveapplicationsystem.service.dto.LeaveApplicationRequest;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveApplicationController {
    private final LeaveApplicationService leaveService;

    @Autowired
    public LeaveApplicationController(LeaveApplicationService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/apply")
    public ResponseEntity<LeaveApplication> applyLeave(@Valid @RequestBody LeaveApplicationRequest request) {
        LeaveApplication leave = leaveService.createLeaveApplication(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(leave);
    }

    @GetMapping("/status/{employeeId}")
    public ResponseEntity<List<LeaveApplicationDTO>> getLeaveStatus(@PathVariable Long employeeId) {
        List<LeaveApplicationDTO> leaves = leaveService.getAllLeavesForEmployee(employeeId);
        return ResponseEntity.ok(leaves);
    }
    @PutMapping("/{leaveId}/status")
    public ResponseEntity<LeaveApplication> updateLeaveStatus(
            @PathVariable Long leaveId,
            @RequestBody LeaveStatus status) {

        LeaveApplication updatedLeave = leaveService.updateLeaveStatus(leaveId, status);

        return ResponseEntity.ok(updatedLeave);
    }

    @PutMapping("/cancel/{leaveId}")
    public ResponseEntity<Void> cancelLeave(@PathVariable Long leaveId) {
        leaveService.cancelLeave(leaveId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/pending")
    public List<LeaveApplicationDTO> getAllPendingLeaveApplications() {
        return leaveService.getAllPendingLeaveApplications();
    }
}
