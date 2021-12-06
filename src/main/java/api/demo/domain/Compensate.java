package api.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "compensation")
@Entity
public class Compensate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compensation_id")
    private Long id;

    private String content;

    private Long price;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voc_id")
    private VOC voc;

    @OneToOne(mappedBy = "compensate",cascade = CascadeType.ALL)
    private Penalty penalty;

    @Builder
    public Compensate(String content, Long price, VOC voc){
        this.content = content;
        this.price = price;
        this.voc = voc;
    }

}
