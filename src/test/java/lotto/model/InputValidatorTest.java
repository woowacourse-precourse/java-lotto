package lotto.model;

import static lotto.model.InputValidator.BONUS_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("보너스 로또 번호 예외처리")
    @Test
    void is_valid_bonus_number() {
        assertThatThrownBy(() -> InputValidator.isValidBonusNumber("17,2,3,4,5,6", "17")).isInstanceOf(
                IllegalArgumentException.class).hasMessage(BONUS_NUMBER_ERROR);
        assertThatCode(() -> InputValidator.isValidBonusNumber("17,2,3,4,5,6", "7")).doesNotThrowAnyException();
    }
}
