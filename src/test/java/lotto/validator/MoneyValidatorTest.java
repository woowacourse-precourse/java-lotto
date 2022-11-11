package lotto.validator;

import static lotto.validator.ErrorMessages.INVALID_PAID_MONEY_MESSAGE;
import static lotto.validator.MoneyValidator.hasValidPaidMoney;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {
    @Test
    @DisplayName("로또의 가격으로 나눠떨어지지 않는 금액을 반환한 경우에는 예외를 반환한다.")
    void validCheckOfInvalidPaidMoney() {
        //given
        int invalidPaidMoney = 1034234;

        //when, then
        assertThatThrownBy(() -> hasValidPaidMoney(invalidPaidMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAID_MONEY_MESSAGE);
    }
}
