package com.platform.pageable.mapper;

import com.platform.pageable.dto.MemberDto;
import com.platform.pageable.entity.Member;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper {

    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    /*@Mapping(source = "qax", target = "baz")
    @Mapping(source = "baz", target = "qax")*/
    Member map(MemberDto source);

    @InheritInverseConfiguration
    MemberDto map(Member entity);
}
