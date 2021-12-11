package api.demo.controller.web;

import api.demo.domain.Attributable;
import api.demo.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberSaveDto {

    private String userId;

    private String name;

    private Attributable attributable;

    public Member toEntity(){
        return Member.builder()
                .userId(userId)
                .name(name)
                .attributable(attributable)
                .build();
    }

}
