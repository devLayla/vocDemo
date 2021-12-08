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

    private List<CompensateResponseDto> compensateList;

    public VocListResponseDto(VOC voc){
        id = voc.getId();
        vocStatus = voc.getVocStatus();
        attributable = voc.getAttributable();
        content = voc.getContent();
        checkDriver = voc.getCheckDriver();
        objection = voc.getObjection();
        totalPrice = voc.getTotalPrice();
        compensateList = voc.getCompensateList().stream()
                .map(CompensateResponseDto::new)
                .collect(Collectors.toList());
    }
}
