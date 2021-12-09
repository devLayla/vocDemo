package api.demo.service;

import api.demo.controller.web.*;
import api.demo.domain.Attributable;
import api.demo.domain.Compensate;
import api.demo.domain.VOC;
import api.demo.domain.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class VocService {

    private final VocRepository vocRepository;
    private final CompensateService compensateService;

    @Transactional
    public Long saveVOC(VocSaveDto createVOCDto){
        if(createVOCDto.getAttributable() == null){
            throw new IllegalArgumentException("귀책이 설정되지 않았습니다. 귀책정보를 입력해주세요.");
        }
        VOC save = vocRepository.save(createVOCDto.toEntity());
        return save.getId();
    }

    public VocResponseDto findById(Long id){
        VOC voc = vocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 voc가 없습니다 = ID : " + id));
        return new VocResponseDto(voc);
    }

    public List<VocListResponseDto> findAll(){
        return vocRepository.findAll().stream()
                .map(VocListResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<VocListResponseDto> findAllByDto(){
        List<VocListResponseDto> findVoc = vocRepository.findAll().stream()
                .map(VocListResponseDto::new)
                .collect(Collectors.toList());

        List<Long> resultIds = findVoc.stream()
                            .map(VocListResponseDto::getId)
                            .collect(Collectors.toList());

        Map<Long, List<CompensateListResponseDto>> compensateMap = compensateService.findAllWithVoc(resultIds);

        findVoc.forEach(v -> v.setCompensate(compensateMap.get(v.getId())));

        return findVoc;
    }

}
