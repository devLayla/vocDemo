package api.demo.controller.web;

import api.demo.domain.Attributable;
import api.demo.domain.VOC;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Getter
public class VocSaveDto {

    @NonNull
    private Attributable attributable;

    private String content;

    private Boolean isClaim;

    private Boolean isCompensate;

    private CompensateSaveDto compensate;

    public VOC toEntity(){
        return VOC.builder()
                .attributable(attributable)
                .content(content)
                .isClaim(isClaim)
                .isCompensate(isCompensate)
                .build();
    }

}
