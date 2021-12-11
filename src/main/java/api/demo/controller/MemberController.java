package api.demo.controller;

import api.demo.controller.web.MemberResponseDto;
import api.demo.controller.web.MemberSaveDto;
import api.demo.domain.Member;
import api.demo.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping("/api/member")
    public Long join(@RequestBody MemberSaveDto memberSaveDto){
        Member save = memberRepository.save(memberSaveDto.toEntity());
        return save.getId();
    }

    @GetMapping("/api/member")
    public List<MemberResponseDto> findAll(){
        return memberRepository.findAll().stream()
                .map(MemberResponseDto::new)
                .collect(Collectors.toList());
    }

}
