package zw.co.psc.leaveapplicationsystem.domain;

import jakarta.persistence.Entity;
import lombok.*;
import zw.co.psc.leaveapplicationsystem.domain.utils.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {
    private String employeeId;
    private String name;
    private String departmentId;
}
