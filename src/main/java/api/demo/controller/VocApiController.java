package api.demo.controller;

import api.demo.controller.web.VocResponseDto;
import api.demo.controller.web.VocSaveDto;
import api.demo.controller.web.VocListResponseDto;
import api.demo.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VocApiController {

    private final VocService vocService;

    @PostMapping("/api/voc/save")
    public Long save(@RequestBody VocSaveDto vocSaveDto){
        return vocService.saveVOC(vocSaveDto);
    }

    @GetMapping("/api/voc")
    public List<VocListResponseDto> findAll(){
        return vocService.findAll();
    }

    @GetMapping("/api/voc/{id}")
    public VocResponseDto findById(@PathVariable Long id){
        return vocService.findById(id);
    }


}
