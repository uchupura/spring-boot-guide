package com.platform.oauth2.service;

import com.platform.oauth2.entity.Member;
import com.platform.oauth2.repository.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

public class DefaultUserDetailsService implements UserDetailsService {

    private final MemberRepository repository;

    public DefaultUserDetailsService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = repository.findByName(username);

        if (member != null) {
            return new User(member.getName(),
                    member.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(member.getPhone())));
        }

        return null;
    }

    private String passwordNoEncoding(Member member) {
        // you can use one of bcrypt/noop/pbkdf2/scrypt/sha256
        // more: https://spring.io/blog/2017/11/01/spring-security-5-0-0-rc1-released#password-encoding
        return "{noop}" + member.getPassword();
    }
}
