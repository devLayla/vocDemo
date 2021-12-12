package api.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "compensate")
@Entity
public class Compensate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensate_id")
    private Long id;

    private String content;

    private Long price;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voc_id")
    private VOC voc;

    @OneToOne(mappedBy = "compensate",cascade = CascadeType.ALL)
    private Penalty penalty;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Compensate(String content, Long price, VOC voc, Member member){
        this.content = content;
        this.price = price;
        this.voc = voc;
        this.member = member;
    }

    public void setVoc(VOC voc){
        this.voc = voc;
    }
}
