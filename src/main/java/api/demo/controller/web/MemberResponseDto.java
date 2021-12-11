package api.demo.controller.web;

import api.demo.domain.Attributable;
import api.demo.domain.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long id;

    private String userId;

    private Attributable attributable;

    public MemberResponseDto(Member member){
        this.id = member.getId();
        this.userId = member.getUserId();
        this.attributable = member.getAttributable();
    }


}
