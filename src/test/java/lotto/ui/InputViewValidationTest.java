package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("당첨 번호 입력의 사이즈가 6 초과일 때 예외처리한다.")
    @Test
    void validateByNumberSizeExceed() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersSize("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력의 사이즈가 6 미만일 때 예외처리한다.")
    @Test
    void validateByNumberSizeSmall() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersSize("2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 수가 아닌 문자가 있을 때 예외처리한다.")
    @Test
    void validateByNumberNotInteger() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersInteger("1,ㄱ,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력은 맨앞에 숫자가 오지 않으면 예외처리한다.")
    @Test
    void validateByStartNumberInvalidFormat() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersFormat(".1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력은 맨뒤에 숫자가 오지 않으면 예외처리한다.")
    @Test
    void validateByEndNumberInvalidFormat() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersFormat("1,2,3,4,5,6."))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력은 ,의 양옆에 숫자가 오지 않으면 예외처리한다.")
    @Test
    void validateByBetweenNumberInvalidFormat() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersFormat("1,2,3,4,,,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력은 1이상 45미만의 숫자가 오지 않으면 예외처리한다.")
    @Test
    void validateByNumberInvalidRange() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersRange("1,2,3,4,0,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력은 중복된 수가 들어오면 예외처리한다.")
    @Test
    void validateByNumberDuplicate() {
        assertThatThrownBy(() -> InputViewValidation.validateWinningNumbersUnique("1,2,3,4,4,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력은 1이상 45미만의 숫자가 오지 않으면 예외처리한다.")
    @Test
    void validateByBonusNumberNotInteger() {
        assertThatThrownBy(() -> InputViewValidation.validateBonusNumberRange("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}