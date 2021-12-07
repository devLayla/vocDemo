package api.demo.controller.web;

import api.demo.domain.*;
import lombok.Getter;

import java.util.List;

@Getter
public class VocListResponseDto {

    private Long id;

    private VocStatus vocStatus;

    private Attributable attributable;

    private String content;

    private String penaltyContent;

    private boolean checkDriver;

    private Objection objection;

    private List<Compensate> compensateList;

    public VocListResponseDto(VOC voc){
        id = voc.getId();
        vocStatus = voc.getVocStatus();
        attributable = voc.getAttributable();
        content = voc.getContent();
        checkDriver = voc.getCheckDriver();
        objection = voc.getObjection();
        compensateList = voc.getCompensateList();
    }
}
