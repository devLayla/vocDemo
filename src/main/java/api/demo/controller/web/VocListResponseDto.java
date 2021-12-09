package api.demo.controller.web;

import api.demo.domain.*;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VocListResponseDto {

    private Long id;

    private VocStatus vocStatus;

    private Attributable attributable;

    private String content;

    private boolean checkDriver;

    private Objection objection;

    private int totalPrice;

    private List<CompensateListResponseDto> compensateList;

    public VocListResponseDto(VOC voc){
        id = voc.getId();
        vocStatus = voc.getVocStatus();
        attributable = voc.getAttributable();
        content = voc.getContent();
        checkDriver = voc.getCheckDriver();
        objection = voc.getObjection();
        totalPrice = voc.getTotalPrice();
        compensateList = voc.getCompensateList().stream()
                .map(CompensateListResponseDto::new)
                .collect(Collectors.toList());
    }

    public VocListResponseDto(Long id, VocStatus vocStatus, Attributable attributable, String content, boolean checkDriver, Objection objection) {
        this.id = id;
        this.vocStatus = vocStatus;
        this.attributable = attributable;
        this.content = content;
        this.checkDriver = checkDriver;
        this.objection = objection;
    }

    public List<CompensateListResponseDto> setCompensate(List<CompensateListResponseDto> list){
        this.compensateList = list;
        return list;
    }
}
