package api.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String name;

    private Attributable attributable;

    @Builder
    public Member(String userId, String name, Attributable attributable){
        this.userId = userId;
        this.name = name;
        this.attributable = attributable;
    }

}
