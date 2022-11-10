package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {
    @DisplayName("숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createPurchasePriceByString() {
        assertThatThrownBy(() -> new PurchasePrice("abcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위가 아닐 경우 예외가 발생한다.")
    @Test
    void createPurchasePriceByUnit() {
        assertThatThrownBy(() -> new PurchasePrice("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원일 경우 예외가 발생한다.")
    @Test
    void createPurchasePriceByZero() {
        assertThatThrownBy(() -> new PurchasePrice("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}