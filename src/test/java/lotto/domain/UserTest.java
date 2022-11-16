package lotto.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.List;


class UserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3ab,cd,e2,1a1", "1,2,3,4,5,6,7,8", "1,2,3,3,5,5", "1,2,45,56,46,-1"})
    void inputWinningNumber(String input) throws Exception{
        User user = new User();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(user::inputWinningNumber)
                        .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "12,4,5", "1,2,6,46,45,0"})
    void inputBonusNumber(String input) throws Exception{
        User user = new User();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Assertions.assertThatThrownBy(user::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);

    }

}