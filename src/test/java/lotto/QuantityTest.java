package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuantityTest {

    @DisplayName("로또 구매 갯수 계산")
    @Test
    void createQuantity() {
        // given
        int purchaseAmount = 8_000;

        // when
        Quantity quantity = new Quantity(purchaseAmount);
        int result = quantity.getNumber();

        // then
        assertThat(result).isEqualTo(8);
    }

    @DisplayName("구입 금액이 1_000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createQuantityByPurchaseAmountNotMatchUnitStandard() {
        // given
        int purchaseAmount = 8_100;

        // expected
        assertThatThrownBy(() -> new Quantity(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}