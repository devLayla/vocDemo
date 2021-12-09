package api.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyRepository extends JpaRepository<Penalty,Long> {

    Penalty findByCompensateId(Long id);

}
