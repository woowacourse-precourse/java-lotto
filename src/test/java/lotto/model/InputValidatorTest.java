package lotto.model;

import static lotto.model.InputValidator.INPUT_BONUS_NUMBER_ERROR;
import static lotto.model.InputValidator.INPUT_MONEY_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("입력한 보너스 로또 번호 예외발생시 false반화")
    @Test
    void is_valid_bonus_number(){
        assertThat(InputValidator.isValidBonusNumber(new Lotto(List.of(17, 2, 3, 4, 5, 6)), "17")).isFalse();
        assertThat(InputValidator.isValidBonusNumber(new Lotto(List.of(17, 2, 3, 4, 5, 6)), "18")).isTrue();
    }

    @DisplayName("보너스 로또 번호 포함 예외처리")
    @Test
    void is_contains_bonus_number() {
        assertThatThrownBy(
                () -> InputValidator.isContainsBonusNumber(new Lotto(List.of(17, 2, 3, 4, 5, 6)), 17)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INPUT_BONUS_NUMBER_ERROR);
        assertThatCode(() -> InputValidator.isContainsBonusNumber(new Lotto(List.of(17, 2, 3, 4, 5, 6)),
                7)).doesNotThrowAnyException();

    }

    @DisplayName("보너스 로또 번호 범위초과 예외처리")
    @Test
    void is_valid_bonus_number_range() {

        assertThatThrownBy(() -> InputValidator.isValidBonusNumberRange(0)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INPUT_BONUS_NUMBER_ERROR);

        assertThatThrownBy(() -> InputValidator.isValidBonusNumberRange(46)).isInstanceOf(
                IllegalArgumentException.class).hasMessage(INPUT_BONUS_NUMBER_ERROR);

        assertThatCode(() -> InputValidator.isValidBonusNumberRange(45)).doesNotThrowAnyException();
        assertThatCode(() -> InputValidator.isValidBonusNumberRange(1)).doesNotThrowAnyException();
    }

    @DisplayName("입력한 금액 예외처리")
    @Test
    void is_valid_money() {
        assertThatThrownBy(() -> InputValidator.isValidDigit("100hh")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MONEY_ERROR);
        assertThatThrownBy(() -> InputValidator.isValidMoneyRange(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MONEY_ERROR);
        assertThatThrownBy(() -> InputValidator.isValidMoneyRange(999)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MONEY_ERROR);
        assertThatThrownBy(() -> InputValidator.isValidMoneyRange(9909)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_MONEY_ERROR);
    }

    @DisplayName("롯도 당첨 번호 잘못 입력시 false 반화")
    @Test
    void is_valid_input(){
        assertThat(InputValidator.isValidTargetLottoNumbers("1,2,3,4,5")).isFalse();
        assertThat(InputValidator.isValidTargetLottoNumbers("1fdaf")).isFalse();
        assertThat(InputValidator.isValidTargetLottoNumbers("1,2,3,4,5,6")).isTrue();
    }
}
