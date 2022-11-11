package lotto.controller.dto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(strings = {"1100", "100", "234124", "10001"})
    @DisplayName("지불금액이 1000으로 나누어 떨어지지않는 예외테스트")
    void isDivisionTest(String input) {
        assertThatThrownBy(() -> new PaymentAmountDto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 지불금액이 1000으로 나누어 떨어지지 않습니다.");
    }
}
