package lotto.model;

import static lotto.constants.LottoConstant.LOTTO_PRICE;
import static lotto.validator.ErrorMessages.INVALID_PAID_MONEY_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    @DisplayName("유효하지 않은 paidMoney 로 객체를 생성하면 객체가 생성되지 않고 예외를 반환한다.")
    void checkCustomerConstructorWithInvalidPaidMoney() {
        //given
        int invalidPaidMoney = LOTTO_PRICE + 1;

        //when, then
        assertThatThrownBy(() -> new Customer(invalidPaidMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PAID_MONEY_ERROR_MESSAGE);

    }
}
