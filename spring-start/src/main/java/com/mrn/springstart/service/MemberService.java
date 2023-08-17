package com.mrn.springstart.service;

import com.mrn.springstart.domain.MemberDto;
import com.mrn.springstart.repository.MemberRepository;
import com.mrn.springstart.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(MemberDto memberDto) {

        validateDuplicateMember(memberDto); // 중복 회원 검증
        memberRepository.save(memberDto);
        return memberDto.getId();
    }

    /**
     * 중복 회원 검증
     */
    private void validateDuplicateMember(MemberDto memberDto) {
        memberRepository.findByName(memberDto.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<MemberDto> findMembers() {
       return memberRepository.findAll();
    }

    /**
     * 회원 한명 조회
     */
    public Optional<MemberDto>  findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
