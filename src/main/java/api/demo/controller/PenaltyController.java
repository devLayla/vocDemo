package api.demo.controller;

import api.demo.controller.web.PenaltyResponseDto;
import api.demo.controller.web.PenaltySaveDto;
import api.demo.service.PenaltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PenaltyController {

    private final PenaltyService penaltyService;

    @PostMapping("/api/compensate/{compensateId}/penalty")
    public Long save(@PathVariable("compensateId") Long id, PenaltySaveDto penaltySaveDto){
        return penaltyService.save(penaltySaveDto);
    }

    @GetMapping("/api/compensate/{compensateId}/penalty")
    public List<PenaltyResponseDto> findAll(@PathVariable("compensateId")Long id){
        return penaltyService.findAll();
    }


}
