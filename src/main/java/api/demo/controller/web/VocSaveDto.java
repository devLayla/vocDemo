package api.demo.controller.web;

import api.demo.domain.Attributable;
import api.demo.domain.VOC;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VocSaveDto {

    private Attributable attributable;

    private String content;

    private String compensateContent;

    private Long price;

    @Builder
    public VocSaveDto(Attributable attributable, String content){
        this.attributable = attributable;
        this.content = content;
    }

    public VOC toEntity(){
        return VOC.builder()
                .attributable(attributable)
                .content(content)
                .build();
    }

}
