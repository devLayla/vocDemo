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
    private Attributable attributable; //귀책 당사자

    @Enumerated(EnumType.STRING)
    private Objection objection = Objection.WAITING; //이의제기 여부

    private String content; //귀책내용

    private Boolean isClaim; //클레임 여부

    private Boolean isCompensate; //배상요청 여부

    @OneToMany(mappedBy = "voc", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Compensate> compensateList = new ArrayList<>();

    @OneToMany(mappedBy = "voc", cascade =  {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Penalty> penaltyList = new ArrayList<>();

    @Builder
    public VOC(Attributable attributable, String content, Boolean isClaim, Boolean isCompensate){
        this.attributable = attributable;
        this.content = content;
        this.isClaim = isClaim;
        this.isCompensate = isCompensate;
    }

   public void addCompensate(Compensate compensate){
        compensateList.add(compensate);
        compensate.setVoc(this);
   }

    public Boolean getDriverSign(){
        int totalSign = 0;

        for(Penalty penalty : penaltyList){
            if(penalty.getIsSign())
                totalSign++;
        }
        return totalSign == penaltyList.size();
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for (Compensate compensate: compensateList){
            totalPrice += compensate.getPrice();
        }
        return totalPrice;
    }







}
