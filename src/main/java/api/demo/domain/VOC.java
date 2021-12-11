package api.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="voc")
@Entity
public class VOC {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voc_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private VocStatus vocStatus; //현재 상태

    @Enumerated(EnumType.STRING)
    private Attributable attributable; //귀책 당사자

    private Boolean checkDriver = false; //기사 확인여부

    @Enumerated(EnumType.STRING)
    private Objection objection = Objection.WAITING; //이의제기 여부

    private String content; //voc 문의내용

    @OneToMany(mappedBy = "voc", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Compensate> compensateList = new ArrayList<>();

    @OneToMany(mappedBy = "voc", cascade =  {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Penalty> penaltyList = new ArrayList<>();

    @Builder
    public VOC(Attributable attributable, String content){
        this.attributable = attributable;
        this.content = content;
        vocStatus = VocStatus.Question;
    }

    public boolean getDriverCheck(){
        int check = 0;
        for(Compensate compensate : compensateList)
        {
            if(!compensate.getPenalty().getIsSign()){
                check++;
            }
        }
        if(check == 0)
            return true;

        return false;
    }

    public Objection objectionYes(){
        return objection = Objection.YES;
    }

    public Objection objectionNo(){
        return objection = Objection.NONE;
    }

    public VocStatus changeStatus(VocStatus vocStatus){
        this.vocStatus = vocStatus;
        return this.vocStatus;
    }

    public Compensate createCompensate(String content, Long price){
        Compensate compensate = Compensate.builder()
                .content(content)
                .price(price)
                .voc(this)
                .build();
        compensateList.add(compensate);
        return compensate;
    }

    public void addCompensate(List<Compensate> compensateList){
        this.compensateList = compensateList;
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for (Compensate compensate: compensateList){
            totalPrice += compensate.getPrice();
        }
        return totalPrice;
    }







}
