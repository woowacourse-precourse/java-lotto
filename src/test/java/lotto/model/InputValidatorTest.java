package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("보너스 로또 번호 예외처리")
    @Test
    void is_valid_bonus_number() {
        assertThat(InputValidator.isValidBonusNumber("17,2,3,4,5,6", "7")).isFalse();
        assertThat(InputValidator.isValidBonusNumber("1,2,3,4,5,6", "1")).isTrue();
    }
}
