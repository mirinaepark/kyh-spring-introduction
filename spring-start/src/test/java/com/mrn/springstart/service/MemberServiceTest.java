package com.mrn.springstart.service;

import com.mrn.springstart.domain.MemberDto;
import com.mrn.springstart.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        MemberDto memberDto = new MemberDto();
        memberDto.setName("hello");

        //when
        Long saveId = memberService.join(memberDto);

        //then
        MemberDto findMemberDto = memberService.findOne(saveId).get();
        assertThat(memberDto.getName()).isEqualTo(findMemberDto.getName());

    }

    @Test
    void 중복_회원_예외() {
        //given
        MemberDto memberDto1 = new MemberDto();
        memberDto1.setName("spring");

        MemberDto memberDto2 = new MemberDto();
        memberDto2.setName("spring");

        //when
        memberService.join(memberDto1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(memberDto2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(memberDto2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */


        //then
    }

    @Test
    void findOne() {
    }
}