package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseMoneyTest {
    @DisplayName("구매 금액이 1000원 이하면 예외가 발생한다.")
    @Test
    void purchaseMoneyUnder1000WON() {
        assertThatThrownBy(() -> new PurchaseMoney(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void purchaseMoneyUnitIs1000WON() {
        assertThatThrownBy(() -> new PurchaseMoney(7600))
                .isInstanceOf(IllegalArgumentException.class);
    }
}