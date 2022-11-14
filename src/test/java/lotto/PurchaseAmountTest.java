package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PurchaseAmountTest {
    @DisplayName("구매 금액이 1000원 단위가 아니면 예외 발생")
    @Test
    void createPurchaseAmountByInvalidAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(1001)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 음수면 예외 발생")
    @Test
    void createPurchaseAmountByNegativeAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(-1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액에 따른 로또 개수")
    @Test
    void getLottoCount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(1000);
        assertThat(purchaseAmount.getLottoCount()).isEqualTo(1);
    }
}
