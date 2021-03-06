package api.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "penalty")
@Entity
public class Penalty {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Long id;

    private Long price;

    private String content;

    private Boolean isSign = false;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compensate_id")
    private Compensate compensate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="voc_id")
    private VOC voc;

    @Builder
    public Penalty(Long price, String content, Compensate compensate){
        this.price = price;
        this.content = content;
        this.compensate = compensate;
        this.voc = compensate.getVoc();
    }

    public void signCheck(){
        isSign = true;
    }

}
