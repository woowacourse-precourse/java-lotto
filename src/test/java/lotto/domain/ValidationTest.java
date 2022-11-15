package lotto.domain;

import lotto.Util.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ValidationTest {

    @DisplayName("입력되는 값이 유효하지 않으면 예외가 발생한다.")
    @Test
    void validateInteger() {
        assertThatThrownBy(() -> Validation.validateInteger(" 99"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력되는 값이 0으로 시작하면 예외가 발생한다.")
    @Test
    void isStartWithZero() {
        assertThatThrownBy(() -> Validation.isStartWithZero("09"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력되는 값이 1000 단위로 나눠 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validateAmount() {
        final int money = 13400;
        final RuntimeException exception = assertThrows(IllegalArgumentException.class
                , () -> Validation.validateAmount(money));
        assertThat(exception.getMessage()).isEqualTo("[ERROR]");
    }

    @DisplayName("입력한 번호의 개수가 6개가 맞지 않다면 예외가 발생한다.")
    @Test
    void validateNumbers() {
        String input = "1,2,3,4,5 6";
        StringTokenizer st = new StringTokenizer(input, ",");
        final RuntimeException exception = assertThrows(IllegalArgumentException.class
                ,() -> Validation.validateNumbers(st.countTokens()));
        assertThat(exception.getMessage()).isEqualTo("[ERROR]");

    }

    @DisplayName("입력한 번호의 범위가 1 ~ 45 안에 없다면 예외가 발생한다.")
    @Test
    void validateRange() {
        int number = 46;
        final RuntimeException exception = assertThrows(IllegalArgumentException.class
                ,() -> Validation.validateRange(number));
        assertThat(exception.getMessage()).isEqualTo("[ERROR]");
    }
}