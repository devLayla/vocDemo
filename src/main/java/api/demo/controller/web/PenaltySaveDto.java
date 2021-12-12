package api.demo.controller.web;

import api.demo.domain.Compensate;
import api.demo.domain.Penalty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PenaltySaveDto {

    private Long vocId;

    private Long compensateId;

    private String content;

    public void setCompensateId(Long compensateId) {
        this.compensateId = compensateId;
    }

    public void setVocId(Long vocId){
        this.vocId = vocId;
    }

    public Penalty toEntity(Compensate compensate){
        return Penalty.builder()
                .price(compensate.getPrice())
                .content(content)
                .compensate(compensate)
                .build();
    }


}
