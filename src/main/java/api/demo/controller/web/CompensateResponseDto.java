package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Getter;

@Getter
public class CompensateResponseDto {

    private Long id;

    private String content;

    private Long price;

    public CompensateResponseDto(Compensate compensate){
        this.id = compensate.getId();
        this.content = compensate.getContent();
        this.price = compensate.getPrice();
    }

}
