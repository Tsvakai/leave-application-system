package zw.co.psc.leaveapplicationsystem.domain;

import jakarta.persistence.*;
import lombok.*;
import zw.co.psc.leaveapplicationsystem.domain.utils.BaseEntity;
import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveStatus;
import zw.co.psc.leaveapplicationsystem.domain.utils.LeaveType;
import zw.co.psc.leaveapplicationsystem.service.dto.LeaveApplicationRequest;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class LeaveApplication extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status = LeaveStatus.PENDING;

    public LeaveApplication(LeaveApplicationRequest request) {
    }
}

