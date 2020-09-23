package com.platform.pageable.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class MemberDto extends BaseDto {

    Long id;
    String name;
    String phone;
}