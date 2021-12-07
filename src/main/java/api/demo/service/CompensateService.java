package api.demo.service;

import api.demo.controller.web.CompensateResponseDto;
import api.demo.controller.web.CompensateSaveDto;
import api.demo.domain.Compensate;
import api.demo.domain.CompensateRepository;
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
    public Long saveCompensate(CompensateSaveDto saveDto){
        Compensate save = compensateRepository.save(saveDto.toEntity());
        //배상접수, 귀책확인 후 배상에 접수처리
        //패널티 생성 입력
        return save.getId();
    }

    public CompensateResponseDto findById(Long id){
        Compensate findOne = compensateRepository.findById(id).get();
        //배상정보와 패널티 정보 로드
        //패널티 확인시 배상금액만큼 배상시스템에 포함
        return new CompensateResponseDto(findOne);

    }

    public List<CompensateResponseDto> findAll(){

        List<Compensate> findAll = compensateRepository.findAll();

        return findAll.stream()
                .map(CompensateResponseDto::new)
                .collect(Collectors.toList());
    }


}
