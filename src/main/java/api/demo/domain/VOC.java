package api.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="voc")
@Entity
public class VOC {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private VocStatus vocStatus;

    @Enumerated(EnumType.STRING)
    private Attributable attributable; //귀책 당사자

    @Enumerated(EnumType.STRING)
    private CheckDriver checkDriver = CheckDriver.WAITING; //기사 확인여부

    @Enumerated(EnumType.STRING)
    private Objection objection = Objection.WAITING; //이의제기 여부

    private String content; //귀책내용

    private String penaltyContent; //패널티 내용

    @OneToOne(mappedBy = "voc", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Compensate compensate;

    @Builder
    public VOC(Attributable attributable, String content){
        this.attributable = attributable;
        this.content = content;
        vocStatus = VocStatus.Question;
    }

    public void addCompensation(Compensate compensate){
        this.compensate = compensate;
    }



}
