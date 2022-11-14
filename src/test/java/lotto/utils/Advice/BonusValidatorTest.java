package lotto.utils.Advice;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BonusValidatorTest {

    @DisplayName("보너스 번호 사이즈가 1, 2가 아니면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Bonus Number = {0}")
    @ValueSource(strings = {
            "", "100", "1000", "10000"
    })
    void checkSize(String input){
        Assertions.assertThatThrownBy(() -> BonusValidator.checkSizeAndNumber(input));
    }

    @DisplayName("보너스 번호가 빈값이 들어가면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Bonus Number = {0}")
    @NullAndEmptySource
    void checkNullAndEmpty(String input){
        Assertions.assertThatThrownBy(() -> BonusValidator.checkSizeAndNumber(input));
    }

    @DisplayName("보너스 번호가 숫자가 아닌 다른값이 들어오면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Bonus Number = {0}")
    @ValueSource(strings = {
            ".", "r0", "1,", "1!", "-+", "-=", "^&"
    })
    void checkNumber(String input){
        Assertions.assertThatThrownBy(() -> BonusValidator.checkSizeAndNumber(input));
    }

    @DisplayName("보너스 번호가 1~45 이외의 번호가 들어오면 예외가 발생한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Bonus Number = {0}")
    @ValueSource(strings = {
            "0", "46", "80,", "88", "99"
    })
    void checkRange(String input){
        Assertions.assertThatThrownBy(() -> BonusValidator.checkRange(input));
    }

}