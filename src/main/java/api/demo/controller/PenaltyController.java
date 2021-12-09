package api.demo.controller;

import api.demo.controller.web.PenaltyResponseDto;
import api.demo.controller.web.PenaltySaveDto;
import api.demo.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PenaltyController {

    private final PenaltyService penaltyService;

    @PostMapping("/api/compensate/{compensateId}/penalty")
    public Long save(@PathVariable("compensateId") Long id, @RequestBody PenaltySaveDto penaltySaveDto){
        penaltySaveDto.setCompensateId(id);
        return penaltyService.save(penaltySaveDto);
    }

    @GetMapping("/api/penalty")
    public List<PenaltyResponseDto> findAll(){
        return penaltyService.findAll();
    }


}
