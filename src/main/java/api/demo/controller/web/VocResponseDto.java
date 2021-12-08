package api.demo.controller.web;

import api.demo.domain.*;
import lombok.Getter;

@Getter
public class VocResponseDto {

    private Long id;

    private VocStatus vocStatus;

    private Attributable attributable;

    private String content;

    private Objection objection;

    public VocResponseDto(VOC voc){
        this.id = voc.getId();
        this.vocStatus = voc.getVocStatus();
        this.attributable = voc.getAttributable();
        this.content = voc.getContent();
        this.objection = voc.getObjection();
    }


}
