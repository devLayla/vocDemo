package api.demo.controller.web;

import api.demo.domain.Compensate;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
        penalty = Optional.ofNullable(compensate.getPenalty())
                .map(PenaltyResponseDto::new)
                .orElse(null);

    }

}
