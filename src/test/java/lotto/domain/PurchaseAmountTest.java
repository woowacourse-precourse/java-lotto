package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("구매 금액이 1000원으로 안 나눠 떨어질 때")
    @Test
    void generatePurchaseAmountByUnDivide1000() {
        int purchaseAmount = 4562;
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 0원일 때")
    @Test
    void generatePurchaseAmountIsZero() {
        int purchaseAmount = 0;
        Assertions.assertThatThrownBy(() -> new PurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 생성")
    @Test
    void generatePurchaseAmount(){
        int money = 1000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(money);
        Assertions.assertThat(purchaseAmount.countLotterySize()).isEqualTo(1);
    }
}