package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Getter;

@Getter
public class CompensateResponseDto {
    //단일검색
    private Long id;

    private String content;

    private Long price;

    private PenaltyResponseDto penalty;

    public CompensateResponseDto(Compensate compensate){
        id = compensate.getId();
        content = compensate.getContent();
        price = compensate.getPrice();
        penalty = new PenaltyResponseDto(compensate.getPenalty());
    }

}
