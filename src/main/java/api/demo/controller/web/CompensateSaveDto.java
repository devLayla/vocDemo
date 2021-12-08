package api.demo.controller.web;

import api.demo.domain.Compensate;
import api.demo.domain.VOC;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompensateSaveDto {

    private String content;
    private Long price;
    private VOC voc;


    @Builder
    public CompensateSaveDto(VOC voc, String content, Long price){
        this.voc = voc;
        this.content = content;
        this.price = price;
    }

    public Compensate toEntity(){
        return Compensate.builder()
                .voc(voc)
                .content(content)
                .price(price)
                .build();
    }

}
