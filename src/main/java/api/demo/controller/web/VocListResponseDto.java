package api.demo.controller.web;

import api.demo.domain.Attributable;
import api.demo.domain.Objection;
import api.demo.domain.VOC;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VocListResponseDto {
//전체정보 조회
    private Long id;

    private Attributable attributable;

    private String content;

    private boolean driverSign = false;

    private Objection objection;

    private int totalPrice;

    private List<CompensateListResponseDto> compensateList;

    private List<PenaltyResponseDto> penaltyList;

    public VocListResponseDto(VOC voc){
        id = voc.getId();
        attributable = voc.getAttributable();
        content = voc.getContent();
        objection = voc.getObjection();
        totalPrice = voc.getTotalPrice();
        driverSign = voc.getDriverSign();
        compensateList = voc.getCompensateList().stream()
                .map(CompensateListResponseDto::new)
                .collect(Collectors.toList());
        penaltyList = voc.getPenaltyList().stream()
                .map(PenaltyResponseDto::new)
                .collect(Collectors.toList());
    }

}
