package lotto.validator;

import lotto.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    public void setup() {
        validator = new Validator();
    }

    @DisplayName("0이상의 정수가 아니면 예외가 발생한다.")
    @Test
    public void validateMoneyLessThen0() throws Exception {
        int money = -1;

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateMoney(money))
                .withMessage(ErrorMessage.ERROR_MONEY);
    }

    @DisplayName("1000단위 숫자가 아니면 예외가 발생한다.")
    @Test
    public void validateMoneyByNot1000Multiples() throws Exception {
        int money = 1100;

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> validator.validateMoney(money))
                .withMessage(ErrorMessage.ERROR_MONEY);
    }
}