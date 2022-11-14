package lotto.valid;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputLottoValidatorTest {
    @DisplayName("로또 구입 금액 입력 예외처리")
    @Test
    void inputMoney() {
        String wrongMoney = "70m6";
        String correctMoney = "7000";

        InputLottoValidator inputLottoValidator = new InputLottoValidator();

        assertThatThrownBy(() -> new InputLottoValidator().validateMoney(wrongMoney))
            .isInstanceOf(IllegalArgumentException.class);

        new InputLottoValidator().validateMoney(correctMoney);
    }

}