package api.demo.service;

import api.demo.controller.web.CompensateResponseDto;
import api.demo.controller.web.CompensateSaveDto;
import api.demo.controller.web.VocResponseDto;
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
        VOC getVoc = vocRepository.findById(saveDto.getVocId()).get();
        Compensate save = compensateRepository.save(saveDto.toEntity(getVoc));

        return save.getId();
    }

    public CompensateResponseDto findById(Long id){
        Compensate findOne = compensateRepository.findById(id).get();

        return new CompensateResponseDto(findOne);

    }

    public List<CompensateResponseDto> findAll(){
        return compensateRepository.findAll().stream()
                .map(CompensateResponseDto::new)
                .collect(Collectors.toList());
    }


}
