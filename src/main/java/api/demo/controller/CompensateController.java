package api.demo.controller;

import api.demo.controller.web.CompensateResponseDto;
import api.demo.controller.web.CompensateSaveDto;
import api.demo.service.CompensateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CompensateController {

    private final CompensateService compensateService;

    @PostMapping("/api/compensate/save")
    public Long save(CompensateSaveDto compensateSaveDto){
        return compensateService.saveCompensation(compensateSaveDto);
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
