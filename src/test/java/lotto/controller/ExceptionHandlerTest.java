package lotto.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ExceptionHandlerTest {

    @Test
    void 입력_금액_숫자_테스트() {
        assertThatThrownBy(() -> ExceptionHandler.validateInputPriceOfString("안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_금액_1000_배수_테스트() {
        assertThatThrownBy(() -> ExceptionHandler.validateInputPriceOfString("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}