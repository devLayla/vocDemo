package api.demo.service;

import api.demo.controller.web.PenaltyResponseDto;
import api.demo.controller.web.PenaltySaveDto;
import api.demo.domain.Compensate;
import api.demo.domain.CompensateRepository;
import api.demo.domain.Penalty;
import api.demo.domain.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PenaltyService {

    private final CompensateRepository compensateRepository;
    private final PenaltyRepository penaltyRepository;

    @Transactional
    public Long save(PenaltySaveDto penaltySaveDto){
        Compensate compensate = compensateRepository.findById(penaltySaveDto.getCompensateId()).get();
        Penalty save = penaltyRepository.save(penaltySaveDto.toEntity(compensate));
        return save.getId();
    }

    public PenaltyResponseDto findById(Long id){
        Penalty findById = penaltyRepository.findById(id).get();
        return new PenaltyResponseDto(findById);
    }

    public List<PenaltyResponseDto> findAll(){
        List<Penalty> findAll = penaltyRepository.findAll();
        return findAll.stream()
                .map(PenaltyResponseDto::new)
                .collect(Collectors.toList());
    }


}
