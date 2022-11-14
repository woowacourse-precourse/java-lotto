package lotto.service;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
}
