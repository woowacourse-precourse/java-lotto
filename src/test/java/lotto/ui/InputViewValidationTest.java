package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewValidationTest {

    @DisplayName("구매 구입 입력에 숫자가 아닌 문자가 들어있을 때 예외처리한다.")
    @Test
    void validateByNotInteger() {
        assertThatThrownBy(() -> InputViewValidation.validateIsInteger("100L"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 구입 입력이 1000 이하의 숫자가 일 때 예외처리한다.")
    @Test
    void validateByNot100() {
        assertThatThrownBy(() -> InputViewValidation.validateIs1000("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 구입 입력이 1000 단위의 숫자가 아닐 때 예외처리한다.")
    @Test
    void validateByNot10001() {
        assertThatThrownBy(() -> InputViewValidation.validateIs1000("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}