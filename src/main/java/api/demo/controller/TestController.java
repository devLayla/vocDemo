package api.demo.controller;

import api.demo.controller.web.CompensateSaveDto;
import api.demo.controller.web.VocSaveDto;
import api.demo.domain.Attributable;
import api.demo.service.CompensateService;
import api.demo.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final VocService vocService;

    @PostMapping("/")
    public void home(){
        initDB();
    }

    private void initDB(){
        VocSaveDto vocSaveDto1 = VocSaveDto.builder()
                .attributable(Attributable.CARRIER)
                .content("배송실수")
                .build();

        VocSaveDto vocSaveDto2 = VocSaveDto.builder()
                .attributable(Attributable.CARRIER)
                .content("상품파손")
                .build();

        VocSaveDto vocSaveDto3 = VocSaveDto.builder()
                .attributable(Attributable.DRIVER)
                .content("배송시각오류")
                .build();

        Long save1 = vocService.saveVOC(vocSaveDto1);
        Long save2 = vocService.saveVOC(vocSaveDto2);
        Long save3 = vocService.saveVOC(vocSaveDto3);

    }


}
