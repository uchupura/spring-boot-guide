package com.platform.pageable.repository;


import com.platform.pageable.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findAllByName(String name, Pageable pageable);
}
