package com.mrn.springstart.service;

import com.mrn.springstart.domain.MemberDto;

import com.mrn.springstart.domain.MemberDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

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
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}