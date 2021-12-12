package api.demo.controller.web;

import api.demo.domain.Compensate;
import lombok.Getter;

import java.util.Optional;

@Getter
public class CompensateVocListResponseDto {
//voc-Member정보 함께 검색
    private Long id;

    private String content;

    private Long price;

    private VocResponseDto voc;

    private MemberResponseDto member;

    public CompensateVocListResponseDto(Compensate compensate){
        id = compensate.getId();
        content = compensate.getContent();
        price = compensate.getPrice();
        voc = new VocResponseDto(compensate.getVoc());
        member = Optional.ofNullable(compensate.getMember())
                .map(MemberResponseDto::new)
                .orElse(null);
    }
}
