package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {
    @DisplayName("숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void purchasePriceByString() {
        assertThatThrownBy(() -> new PurchasePrice("abcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}