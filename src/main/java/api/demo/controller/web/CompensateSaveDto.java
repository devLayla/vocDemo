package api.demo.controller.web;

import api.demo.domain.Compensate;
import api.demo.domain.VOC;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CompensateSaveDto {

    private Long vocId;
    private String content;
    private Long price;

    public void setVocId(Long vocId){
        this.vocId = vocId;
    }

    @Builder
    public CompensateSaveDto(String content, Long price){
        this.content = content;
        this.price = price;
    }

    public Compensate toEntity(VOC voc){
        return Compensate.builder()
                .voc(voc)
                .content(content)
                .price(price)
                .build();
    }

}
