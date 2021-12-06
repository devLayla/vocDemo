package api.demo.service;

import api.demo.controller.web.CompensateResponseDto;
import api.demo.controller.web.CompensateSaveDto;
import api.demo.domain.Compensate;
import api.demo.repository.CompensateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class CompensateService {

    private final CompensateRepository compensateRepository;

    @Transactional
    public Long saveCompensation(CompensateSaveDto saveDto){
        Compensate save = compensateRepository.save(saveDto.toEntity());
        return save.getId();
    }

    public CompensateResponseDto findById(Long id){
        Compensate findOne = compensateRepository.findById(id).get();
        return new CompensateResponseDto(findOne);

    }

    public List<CompensateResponseDto> findAll(){

        List<Compensate> findAll = compensateRepository.findAll();

        return findAll.stream()
                .map(CompensateResponseDto::new)
                .collect(Collectors.toList());
    }


}
