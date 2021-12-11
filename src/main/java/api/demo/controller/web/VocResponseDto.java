package api.demo.controller.web;

import api.demo.domain.*;
import lombok.Getter;

@Getter
public class VocResponseDto {
//단일검색
    private Long id;

    private Attributable attributable;

    private String content;

    private Objection objection;

    private Boolean driverSign;

    public VocResponseDto(VOC voc){
        this.id = voc.getId();
        this.attributable = voc.getAttributable();
        this.content = voc.getContent();
        this.objection = voc.getObjection();
        this.driverSign = voc.getDriverSign();
    }


}
