package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {


    @DisplayName("구매 금액이 1_000으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void purchaseAmountException() {
        PurchaseException purchaseException = new PurchaseException();

        assertThatThrownBy(() -> purchaseException.validatePurchaseAmount("10100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 숫자가 아니면 예외 발생")
    @Test
    void checkPurchaseAmount() {
        PurchaseException purchaseException = new PurchaseException();

        assertThatThrownBy(() -> purchaseException.validatePurchaseAmount("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
