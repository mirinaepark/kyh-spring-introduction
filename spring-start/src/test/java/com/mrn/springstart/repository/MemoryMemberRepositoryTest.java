package com.mrn.springstart.repository;

import com.mrn.springstart.domain.MemberDto;
import com.mrn.springstart.domain.MemberDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        MemberDto memberDto = new MemberDto();
        memberDto.setName("spring");

        repository.save(memberDto);

        MemberDto result = repository.findById(memberDto.getId()).get();

        assertThat(memberDto).isEqualTo(result);

    }
    
    @Test
    public void findByName(){

        MemberDto member1 = new MemberDto();
        member1.setName("spring1");
        repository.save(member1);
        
        MemberDto member2 = new MemberDto();
        member2.setName("spring1");
        repository.save(member2);

        MemberDto result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){

        MemberDto member1 = new MemberDto();
        member1.setName("spring1");
        repository.save(member1);

        MemberDto member2 = new MemberDto();
        member2.setName("spring2");
        repository.save(member2);

        List<MemberDto>  result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
