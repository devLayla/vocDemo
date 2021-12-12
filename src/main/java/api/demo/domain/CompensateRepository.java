package api.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompensateRepository extends JpaRepository<Compensate, Long> {

    @Query("select c from Compensate c join c.voc v where c.voc.id in :vocIds")
   List<Compensate> findAllWithVoc(@Param("vocIds") List<Long> vocIds);

}
