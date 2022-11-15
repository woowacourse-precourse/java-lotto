package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentCalculatorTest {
    @DisplayName("구입 금액이 음수이면 예외가 발생")
    @Test
    void createCalculatorByNegativePayment() {
        assertThatThrownBy(() -> new PaymentCalculator(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MONEY_NEGATIVE.getValue());
    }

    @DisplayName("구입 금액이 양수이지만 1,000보다 작으면 예외가 발생")
    @Test
    void createCalculatorByInsufficientPayment() {
        assertThatThrownBy(() -> new PaymentCalculator(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PAYMENT_INSUFFICIENT.getValue());
    }

    @DisplayName("구입 금액이 1,000보다 크지만 나머지가 존재하면 예외가 발생")
    @Test
    void createCalculatorByHavingRemainder() {
        assertThatThrownBy(() -> new PaymentCalculator(1200))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PAYMENT_HAS_REMAINDER.getValue());
    }

    @DisplayName("수익률 계산 시 총 상금이 음수이면 예외가 발생")
    @Test
    void calculateEarningRatioByNegativePrize() {
        assertThatThrownBy(() -> new PaymentCalculator(6000).calculateEarningRatio(-10000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MONEY_NEGATIVE.getValue());
    }
}