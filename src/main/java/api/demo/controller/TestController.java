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
    private final CompensateService compensateService;

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

        vocService.saveVOC(vocSaveDto1);
        vocService.saveVOC(vocSaveDto2);
        vocService.saveVOC(vocSaveDto3);

        CompensateSaveDto compensateSaveDto1 = CompensateSaveDto.builder()
                .content("배송오류")
                .price(10000L)
                .build();

        CompensateSaveDto compensateSaveDto2 = CompensateSaveDto.builder()
                .content("상품파손")
                .price(30000L)
                .build();

        CompensateSaveDto compensateSaveDto3 = CompensateSaveDto.builder()
                .content("배송오류")
                .price(20000L)
                .build();

        compensateService.saveCompensate(compensateSaveDto1);
        compensateService.saveCompensate(compensateSaveDto2);
        compensateService.saveCompensate(compensateSaveDto3);
    }


}
