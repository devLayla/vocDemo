package api.demo.repository;

import api.demo.domain.VOC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocRepository extends JpaRepository<VOC, Long> {

}
