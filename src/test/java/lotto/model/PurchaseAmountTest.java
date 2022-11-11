package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest {
    @DisplayName("구입 금액이 1000원 이하이면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByLess1000() {
        assertThatThrownBy(() -> new PurchaseAmount(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNotDivide1000() {
        assertThatThrownBy(() -> new PurchaseAmount(13500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}