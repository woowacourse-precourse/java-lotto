package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.util.LottoNumberFormatValidator.validateInteger;
import static lotto.util.LottoNumberFormatValidator.validateLottoNumberFormat;

class LottoNumberFormatValidatorTest {

    @DisplayName("입력값이 숫자가 아닌 경우 예외를 발생한다")
    @Test
    void inputNumberByNonNumber() {
        Assertions.assertThatThrownBy( () -> validateInteger("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자가 아닌 경우 예외를 발생한다")
    @Test
    void inputNumberByInvalidRange() {
        Assertions.assertThatThrownBy( () -> validateLottoNumberFormat(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}