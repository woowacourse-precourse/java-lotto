package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchasingAmountTest {

    @Test
    @DisplayName("구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    void createPurchasingAmountByIsNotDividableMoney() {
        assertThatThrownBy(() -> new PurchasingAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INCORRECT_PURCHASING_AMOUNT.toString());
    }
}