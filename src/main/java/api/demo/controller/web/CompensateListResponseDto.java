package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Getter;

@Getter
public class CompensateListResponseDto {
    //voc리스트에 포함되는 dto
    private Long id;

    private String content;

    private Long price;

    public CompensateListResponseDto(Compensate compensate) {
        this.id = compensate.getId();
        this.content = compensate.getContent();
        this.price = compensate.getPrice();
    }

}
