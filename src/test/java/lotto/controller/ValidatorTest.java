package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setup() {
        validator = new Validator();
    }

    @DisplayName("적절한 형태의 숫자 문자열인지 확인")
    @Test
    void checkIsNumberByInvalidNumber() {
        assertThatThrownBy(() -> validator.isNumber("1d23"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.isNumber("0123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("적절한 형태의 숫자만 받는지 확인")
    @Test
    void checkAmountByInvalidNumber() {
        assertThatThrownBy(() -> validator.checkAmount(1233434))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
