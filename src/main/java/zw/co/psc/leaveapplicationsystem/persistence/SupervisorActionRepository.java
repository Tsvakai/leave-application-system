package zw.co.psc.leaveapplicationsystem.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.psc.leaveapplicationsystem.domain.SupervisorAction;

public interface SupervisorActionRepository extends JpaRepository<SupervisorAction, Long> {
}
