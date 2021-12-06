package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompensateSaveDto {

    private String content;
    private Long price;

    @Builder
    public CompensateSaveDto(String content, Long price){
        this.content = content;
        this.price = price;
    }

    public Compensate toEntity(){
        return Compensate.builder()
                .content(content)
                .price(price)
                .build();
    }

}
