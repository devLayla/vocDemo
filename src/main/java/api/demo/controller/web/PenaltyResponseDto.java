package api.demo.controller.web;

import api.demo.domain.Penalty;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class PenaltyResponseDto {

    private Long id;

    private Long price;

    private String content;

    private Boolean isSign;

    public PenaltyResponseDto(Penalty penalty){
        this.id = penalty.getId();
        this.price = penalty.getPrice();
        this.content = penalty.getContent();
        this.isSign = penalty.getIsSign();
    }

}
