package lotto;

import lotto.domain.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByString() {
        assertThatThrownBy(() -> inputValidator.validateNumeric("fff"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자 외의 문자가 존재하면 예외가 발생한다.")
    @Test
    void createWinningNumbersByString() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,a,b,c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 중 0 이하 또는 46 이상의 번호가 존재하면 예외가 발생한다.")
    @Test
    void createWinningNumbersByWrongNumber() {
        assertThatThrownBy(() -> inputValidator.validateWinningNumbers("1,2,3,46,4,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
