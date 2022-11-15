package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ValidationUtils 메서드를 테스트한다.")
class ValidationUtilsTest {
    @DisplayName(",로 구분되는 숫자 형식이 아니면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,j", "+,1,2,3,4,5", "1,2,ㄱ,4,5,6", "1,2,3,4,5|6"})
    void validateWinningNumberFormat(String number) {
        assertThatThrownBy(() -> ValidationUtils.validateWinningNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 형식이 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"k", "+", "ㄱ"})
    void validateBonusNumberFormat(String number) {
        assertThatThrownBy(() -> ValidationUtils.validateBonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈이 너무 적으면 로또를 구매할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "-300", "500", "999"})
    void throwExceptionWhenMoneyIsTooLittle(String money) {
        assertThatThrownBy(() -> ValidationUtils.validateMoneyAmount(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}