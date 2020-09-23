package com.platform.common.app.controller;

import com.platform.core.util.CommonUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @GetMapping("/hello")
    public String hello(String name) {

        if (CommonUtil.isNull(name)) {
            return "Hello World";
        }
        return "Hello " + name;
    }
}
