package com.platform.oauth2.service;

import com.platform.oauth2.dto.Filter;
import com.platform.oauth2.dto.MemberDto;
import com.platform.oauth2.entity.Member;
import com.platform.oauth2.exception.NotFoundException;
import com.platform.oauth2.mapper.MemberMapper;
import com.platform.oauth2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService implements BaseService<MemberDto, Long> {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository repository;


    @Override
    public List<MemberDto> readAll() {

        List<Member> members = repository.findAll();
        return members.stream()
                .map(m -> {
                    return MemberMapper.INSTANCE.map(m);
                })
                .collect(Collectors.toList());
    }

    @Override
    public Page<MemberDto> search(Pageable pageable) {

        Page<Member> members = repository.findAll(pageable);
        return members.map(m -> {
            return MemberMapper.INSTANCE.map(m);
        });
    }


    @Transactional
    @Override
    public MemberDto create(MemberDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Member entity = MemberMapper.INSTANCE.map(dto);
        Member member = repository.save(entity);
        return MemberMapper.INSTANCE.map(member);
    }

    @Override
    public MemberDto read(Long id) {
        Member member = repository.findById(id).orElseThrow(() -> new NotFoundException("member"));
        return MemberMapper.INSTANCE.map(member);
    }

    @Transactional
    @Override
    public MemberDto update(Long id, MemberDto dto) {
        Member member = repository.findById(id).orElseThrow(() -> new NotFoundException("member"));
        member.update(dto.getName(), dto.getPhone());
        return MemberMapper.INSTANCE.map(member);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    public Page<MemberDto> search(Filter filter, Pageable pageable) {

        Page<Member> members = repository.findAllByName(filter.getName(), pageable);
        return members.map(m -> {
            return MemberMapper.INSTANCE.map(m);
        });
    }
}