package com.platform.pageable.resolver;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostPageable {

    int size() default 30;

    int page() default 0;

    String[] sort() default {};
}
