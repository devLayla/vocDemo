package api.demo.controller;

import api.demo.controller.web.CompensateResponseDto;
import api.demo.controller.web.CompensateSaveDto;
import api.demo.service.CompensateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CompensateController {

    private final CompensateService compensateService;

    @PostMapping("/api/voc/{vocId}/compensate")
    public Long save(@PathVariable("vocId") Long vocId, @RequestBody CompensateSaveDto compensateSaveDto){
        compensateSaveDto.setVocId(vocId);
        return compensateService.saveCompensate(compensateSaveDto);
    }

    @GetMapping("/api/compensate")
    public List<CompensateResponseDto> findAll(){
        return compensateService.findAll();
    }

    @GetMapping("/api/compensate/{id}")
    public CompensateResponseDto findById(@PathVariable Long id){
        return compensateService.findById(id);
    }

}
