package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {

    private static final int WRONG_AMOUNT = 8_400;

    @DisplayName("구입 금액이 1,000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseByWrongAmount() {
        assertThatThrownBy(() -> new Purchase(WRONG_AMOUNT))
                .isInstanceOf(IllegalArgumentException.class);
    }

}