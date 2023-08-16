package com.mrn.springstart.repository;

import com.mrn.springstart.domain.MemberDto;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, MemberDto> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public MemberDto save(MemberDto memberDto) {
        memberDto.setId(++sequence);
        store.put(memberDto.getId(), memberDto);
        return memberDto;
    }

    @Override
    public Optional<MemberDto> findById(Long id) {
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<MemberDto> findByName(String name) {
        return store.values().stream()
                .filter(MemberDto -> MemberDto.getName().equals(name))
                .findAny();

    }

    @Override
    public List<MemberDto>  findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
