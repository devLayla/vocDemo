package api.demo.domain;

import api.demo.controller.web.VocListResponseDto;
import api.demo.domain.VOC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VocRepository extends JpaRepository<VOC, Long> {

    @Query("select new api.demo.controller.web.VocListResponseDto" +
            "(v.id,v.vocStatus, v.attributable, v.content, v.checkDriver, v.objection)" +
            " from VOC v")
    List<VocListResponseDto> findAllExceptMany();



}
