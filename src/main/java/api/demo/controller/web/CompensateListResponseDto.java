package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Getter;

@Getter
public class CompensateListResponseDto {
    //voc, Member 동시 검색
    private Long id;

    private String content;

    private Long price;

    private VocResponseDto voc;

    private MemberResponseDto member;

    public CompensateListResponseDto(Compensate compensate){
        id = compensate.getId();
        content = compensate.getContent();
        price = compensate.getPrice();
        voc = new VocResponseDto(compensate.getVoc());
        member = new MemberResponseDto(compensate.getMember());
    }
}
