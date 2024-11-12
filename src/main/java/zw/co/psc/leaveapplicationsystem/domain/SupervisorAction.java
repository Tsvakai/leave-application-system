package zw.co.psc.leaveapplicationsystem.domain;

import jakarta.persistence.*;
import lombok.*;
import zw.co.psc.leaveapplicationsystem.domain.utils.ActionType;
import zw.co.psc.leaveapplicationsystem.domain.utils.BaseEntity;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class SupervisorAction extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "leave_application_id", nullable = false)
    private LeaveApplication leaveApplication;

    private Long supervisorId;
    private LocalDate actionDate;
    private String comments;

    @Enumerated(EnumType.STRING)
    private ActionType actionType;

}
