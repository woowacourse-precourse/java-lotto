package lotto.model;

import static lotto.model.InputValidator.INPUT_BONUS_NUMBER_ERROR;
import static lotto.model.InputValidator.INPUT_MONEY_ERROR;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("보너스 로또 번호 포함 예외처리")
    @Test
    void is_contains_bonus_number() {
        assertThatThrownBy(() -> InputValidator.isContainsBonusNumber("17,2,3,4,5,6", "17")).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INPUT_BONUS_NUMBER_ERROR);
        assertThatCode(() -> InputValidator.isContainsBonusNumber("17,2,3,4,5,6", "7")).doesNotThrowAnyException();

    }

    @DisplayName("보너스 로또 번호 범위 예외처리")
    @Test
    void is_valid_bonus_number_range() {

        assertThatThrownBy(() -> InputValidator.isValidBonusNumberRange("0")).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INPUT_BONUS_NUMBER_ERROR);

        assertThatThrownBy(() -> InputValidator.isValidBonusNumberRange("46")).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INPUT_BONUS_NUMBER_ERROR);

        assertThatCode(() -> InputValidator.isValidBonusNumberRange("45")).doesNotThrowAnyException();
        assertThatCode(() -> InputValidator.isValidBonusNumberRange("1")).doesNotThrowAnyException();
    }

    @DisplayName("입력한 금액 예외처리")
    @Test
    void is_valid_money() {
        assertThatThrownBy(() -> InputValidator.isValidMoney("0")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MONEY_ERROR);
        assertThatThrownBy(() -> InputValidator.isValidMoney("999")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MONEY_ERROR);
        assertThatThrownBy(() -> InputValidator.isValidMoney("9909")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MONEY_ERROR);
    }
}
