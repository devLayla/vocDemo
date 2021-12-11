package api.demo.controller.web;

import api.demo.domain.*;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VocListResponseDto {
//compensate포함검색
    private Long id;

    private Attributable attributable;

    private String content;

    private boolean driverSign;

    private Objection objection;

    private int totalPrice;

    private List<CompensateResponseDto> compensateList;

    public VocListResponseDto(VOC voc){
        id = voc.getId();
        attributable = voc.getAttributable();
        content = voc.getContent();
        objection = voc.getObjection();
        totalPrice = voc.getTotalPrice();
        driverSign = voc.getDriverSign();
        compensateList = voc.getCompensateList().stream()
                .map(CompensateResponseDto::new)
                .collect(Collectors.toList());
    }

}
