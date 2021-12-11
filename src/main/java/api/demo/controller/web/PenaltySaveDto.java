package api.demo.controller.web;

import api.demo.domain.Compensate;
import api.demo.domain.Penalty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PenaltySaveDto {

    private Long compensateId;

    private Long price;

    private String content;

    public void setCompensateId(Long compensateId) {
        this.compensateId = compensateId;
    }

    public Penalty toEntity(Compensate compensate){
        return Penalty.builder()
                .price(price)
                .content(content)
                .compensate(compensate)
                .build();
    }


}
