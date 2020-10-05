package com.platform.oauth2.repository;


import com.platform.oauth2.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findAllByName(String name, Pageable pageable);

    Member findByName(String name);
}
