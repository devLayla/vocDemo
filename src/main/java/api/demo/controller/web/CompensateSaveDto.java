package api.demo.controller.web;

import api.demo.domain.Compensate;
import api.demo.domain.VOC;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CompensateSaveDto {

    private String content;

    private Long price;

    private Long vocId;

    public void setVocId(Long vocId){
        this.vocId = vocId;
    }

    public Compensate toEntity(VOC voc){
        return Compensate.builder()
                .voc(voc)
                .content(content)
                .price(price)
                .build();
    }

    public Compensate toEntity(){
        return Compensate.builder()
                .content(content)
                .price(price)
                .build();
    }

}
