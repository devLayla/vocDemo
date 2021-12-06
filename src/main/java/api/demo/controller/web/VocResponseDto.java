package api.demo.controller.web;

import api.demo.domain.*;
import lombok.Getter;

@Getter
public class VocResponseDto {

    private Long id;

    private VocStatus vocStatus;

    private Attributable attributable;

    private String content;

    private String penaltyContent;

    private CheckDriver checkDriver;

    private Objection objection;

    private Compensate compensate;

    public VocResponseDto(VOC voc){
        this.id = voc.getId();
        this.vocStatus = voc.getVocStatus();
        this.attributable = voc.getAttributable();
        this.content = voc.getContent();
        this.penaltyContent = voc.getPenaltyContent();
        this.checkDriver = voc.getCheckDriver();
        this.objection = voc.getObjection();
        this.compensate = voc.getCompensate();
    }


}
