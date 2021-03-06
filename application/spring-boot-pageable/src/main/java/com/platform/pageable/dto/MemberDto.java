package com.platform.pageable.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class MemberDto {

    Long id;
    String name;
    String phone;
    LocalDateTime createdDate;
    LocalDateTime lastModifiedDate;
}