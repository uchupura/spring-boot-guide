package com.platform.common.app.controller;

import com.platform.common.app.dto.MemberDto;
import com.platform.common.app.service.MemberService;
import lombok.extern.slf4j.Slf4j;
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

//    @Inject
//    protected MemberController(CityRepository repository) {
//        super(URI, repository, MAPPER);
//    }
}