package com.mrn.springstart.repository;

import com.mrn.springstart.domain.MemberDto;
import com.mrn.springstart.domain.MemberDto;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    MemberDto save(MemberDto memberDto);
    Optional<MemberDto>  findById(Long id);
    Optional<MemberDto>  findByName(String name);
    List<MemberDto> findAll();

}
