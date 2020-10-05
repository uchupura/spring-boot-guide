package com.platform.oauth2.controller;

import com.platform.oauth2.dto.Filter;
import com.platform.oauth2.dto.MemberDto;
import com.platform.oauth2.resolver.PostPageable;
import com.platform.oauth2.resolver.RequestBodyWithPageable;
import com.platform.oauth2.service.MemberService;
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

    protected MemberController(MemberService memberService) {
        super(URI, memberService);
    }

    @PostMapping("search")
    public Page<MemberDto> search(@RequestBodyWithPageable Filter filter, @PostPageable Pageable pageable) {
        return ((MemberService)service).search(filter, pageable);
    }
}