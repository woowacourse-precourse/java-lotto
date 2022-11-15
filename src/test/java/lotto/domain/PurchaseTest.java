package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    @DisplayName("구매 금액이 1,000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void generatePurchaseByInvalidUnit() {
        assertThatThrownBy(() -> Purchase.generate("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 입력값이 정수형이 아니라면 예외가 발생한다.")
    @Test
    void generatePurchaseByNonIntegerType() {
        assertThatThrownBy(() -> Purchase.generate("1,000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}