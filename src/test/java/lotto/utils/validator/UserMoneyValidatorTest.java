package lotto.utils.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserMoneyValidatorTest {

    @Test
    void 예외_구매금액_1000단위가아님() {
        String money = "12345";
        Assertions.assertThatThrownBy(() -> UserMoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_구매금액_숫자가아닌_문자_포함() {
        String money = "1000a";
        Assertions.assertThatThrownBy(() -> UserMoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_0미만의_수() {
        String money = "-1000";
        Assertions.assertThatThrownBy(() -> UserMoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_long_범위_이상의_수() {
        String money = "10000000000000000000000000000000000";
        Assertions.assertThatThrownBy(() -> UserMoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}