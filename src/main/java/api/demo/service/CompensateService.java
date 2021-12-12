package api.demo.service;

import api.demo.controller.web.CompensateResponseDto;
import api.demo.controller.web.CompensateSaveDto;
import api.demo.controller.web.CompensateVocListResponseDto;
import api.demo.domain.Compensate;
import api.demo.domain.CompensateRepository;
import api.demo.domain.VOC;
import api.demo.domain.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CompensateService {

    private final VocRepository vocRepository;
    private final CompensateRepository compensateRepository;

    @Transactional
    public Long saveCompensate(CompensateSaveDto saveDto){
        VOC findVoc = vocRepository.findById(saveDto.getVocId())
                .orElseThrow(() -> new IllegalArgumentException("해당 voc가 없습니다 = ID : " + saveDto.getVocId()));
        Compensate save = compensateRepository.save(saveDto.toEntity(findVoc));
        return save.getId();
    }

    public CompensateVocListResponseDto findById(Long id){
        Compensate findOne = compensateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 배상정보가 없습니다 = ID : " + id));

        return new CompensateVocListResponseDto(findOne);

    }

    public List<CompensateResponseDto> findAll(){
        return compensateRepository.findAll().stream()
                .map(CompensateResponseDto::new)
                .collect(Collectors.toList());
    }


}
