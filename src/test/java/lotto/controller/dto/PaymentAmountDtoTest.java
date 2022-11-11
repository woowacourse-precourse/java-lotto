package lotto.controller.dto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PaymentAmountDtoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000j", "12-3", "1 2", "j1000"})
    @DisplayName("지불금액 정수값이 아닌 값이 포함 예외테스트")
    void isIntegerTest(String input) {
        assertThatThrownBy(() -> new PaymentAmountDto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 지불금액에 정수값이 아닌 값이 포함되어 있습니다.");
    }
}
