package api.demo.service;

import api.demo.controller.web.VocResponseDto;
import api.demo.controller.web.VocSaveDto;
import api.demo.controller.web.VocListResponseDto;
import api.demo.domain.VOC;
import api.demo.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class VocService {

    private final VocRepository vocRepository;

    @Transactional
    public Long saveVOC(VocSaveDto createVOCDto){
        VOC getID = vocRepository.save(createVOCDto.toEntity());
        return getID.getId();
    }

    public VocResponseDto findById(Long id){
        VOC voc = vocRepository.findById(id).get();
        return new VocResponseDto(voc);
    }

    public List<VocListResponseDto> findAll(){
        return vocRepository.findAll().stream()
                .map(VocListResponseDto::new)
                .collect(Collectors.toList());
    }

}
