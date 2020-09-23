package com.platform.pageable.controller;

import com.platform.pageable.dto.Filter;
import com.platform.pageable.dto.MemberDto;
import com.platform.pageable.resolver.PostPageable;
import com.platform.pageable.resolver.RequestBodyWithPageable;
import com.platform.pageable.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(MemberController.URI)
public class MemberController extends BaseController<MemberDto, Long> {

    public static final String URI = "/api/members";

    private MemberService memberService;

    protected MemberController(MemberService memberService) {
        super(URI, memberService);
        this.memberService = memberService;
    }

    @PostMapping("search")
    public Page<MemberDto> search(@RequestBodyWithPageable Filter filter, @PostPageable Pageable pageable) {
        return memberService.search(filter, pageable);
    }
}