package lotto.controller.dto;


import lotto.controller.validator.BonusNumberValidator;
import lotto.controller.validator.WinningNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningNumbersDtoTest {

    @DisplayName("당첨 번호가 조건에 맞지 않으면 예외가 발생한다.")
    @Test
    void inputInvalidWinningNumber() {
        assertAll(
                () -> assertThatThrownBy(() -> new WinningNumbersDto("1 2 3 4", "8"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(WinningNumberValidator.IS_SEPERATED_BY_COMMA.getErrorMessage()),

                () -> assertThatThrownBy(() -> new WinningNumbersDto("f,d,f,", "8"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]")
        );
    }

    @DisplayName("보너스 번호가 조건에 맞지 않으면 예외가 발생한다.")
    @Test
    void inputInvalidBonusNumber() {
        assertAll(
                () -> assertThatThrownBy(() -> new WinningNumbersDto("1,2,3,4,5,6", "f"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BonusNumberValidator.IS_NATURAL_NUMBER.getErrorMessage()),

                () -> assertThatThrownBy(() -> new WinningNumbersDto("1,2,3,4,5,6", "89"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(BonusNumberValidator.IS_IN_BOUNDS.getErrorMessage())
        );
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void duplicateNumbers() {
        assertThatThrownBy(() -> new WinningNumbersDto("1,2,3,4,5,6", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
