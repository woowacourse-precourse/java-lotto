package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.math.BigInteger;
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

    @DisplayName("int 최대 값을 넘어갈 경우 예외가 발생한다.")
    @Test
    void createPurchasePriceByIntMaxValue() {
        String purchasePrice = new BigInteger(
                "123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789").toString();
        assertThatThrownBy(() -> new PurchasePrice(purchasePrice)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위 숫자는 성공한다.")
    @Test
    void createPurchasePrice() {
        assertDoesNotThrow(() -> new PurchasePrice("1000"));
        assertDoesNotThrow(() -> new PurchasePrice("2000"));
        assertDoesNotThrow(() -> new PurchasePrice("10000"));
        assertDoesNotThrow(() -> new PurchasePrice("30000"));
        assertDoesNotThrow(() -> new PurchasePrice("55000"));
    }
}