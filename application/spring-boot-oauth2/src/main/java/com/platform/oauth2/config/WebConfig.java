package com.platform.oauth2.config;

import com.platform.oauth2.resolver.PostPageableArgumentResolver;
import com.platform.oauth2.resolver.RequestBodyWithPageableArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final PostPageableArgumentResolver postPageableArgumentResolver;

    private final RequestBodyWithPageableArgumentResolver requestBodyWithPageableArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(postPageableArgumentResolver);
        argumentResolvers.add(requestBodyWithPageableArgumentResolver);
    }
}