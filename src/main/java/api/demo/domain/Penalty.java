package api.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
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

    private String content;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compensation_id")
    private Compensate compensate;


}
