package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Getter;

@Getter
public class CompensateListResponseDto {

    private Long id;

    private String content;

    private Long price;

    public CompensateListResponseDto(Compensate compensate){
        id = compensate.getId();
        content = compensate.getContent();
        price = compensate.getPrice();
    }

}
