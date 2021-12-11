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
        Compensate compensate = compensateRepository.findById(penaltySaveDto.getCompensateId())
                .orElseThrow(() -> new IllegalArgumentException("해당 Compensate가 없습니다 = ID : " + penaltySaveDto.getCompensateId()));

        validateDuplicatePenalty(penaltySaveDto.getCompensateId());

        Penalty save = penaltyRepository.save(penaltySaveDto.toEntity(compensate));
        return save.getId();
    }

    private void validateDuplicatePenalty(Long compensateId){
        Penalty byCompensateId = penaltyRepository.findByCompensateId(compensateId);

        if(byCompensateId != null){
            throw new IllegalStateException("이미 발급된 패널티 입니다");
        }
    }

    public PenaltyResponseDto findById(Long id){
        Penalty findById = penaltyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 패널티정보가 없습니다 = ID : " + id));
        return new PenaltyResponseDto(findById);
    }

    public List<PenaltyResponseDto> findAll(){
        List<Penalty> findAll = penaltyRepository.findAll();
        return findAll.stream()
                .map(PenaltyResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long checkSign(Long id){
        Penalty findOne = penaltyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 패널티 정보가 없습니다 = ID : " + id));
        findOne.signCheck();

        return findOne.getId();
    }


}
