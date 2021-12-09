package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Getter;

@Getter
public class CompensateResponseDto {

    private Long id;

    private String content;

    private Long price;

    private PenaltyResponseDto penalty;

    public CompensateResponseDto(Compensate compensate){
        this.id = compensate.getId();
        this.content = compensate.getContent();
        this.price = compensate.getPrice();
       // this.penalty = new PenaltyResponseDto(compensate.getPenalty());
    }


}
