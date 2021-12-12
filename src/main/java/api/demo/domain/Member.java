package api.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Attributable attributable;

    @Builder
    public Member(String userId, String name, Attributable attributable){
        this.userId = userId;
        this.name = name;
        this.attributable = attributable;
    }

}
