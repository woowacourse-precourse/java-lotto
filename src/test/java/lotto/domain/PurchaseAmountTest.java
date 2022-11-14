package lotto.domain;

import static lotto.io.Message.INPUT_UNIT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("구매금액 입력")
    @Test
    void testInputPurchaseAmount() {
        String input = "10000";
        long price = Long.parseLong(input);

        PurchaseAmount purchaseAmount = new PurchaseAmount(input);
        assertThat(purchaseAmount.getLottoAmount()).isEqualTo(price / Lotto.PRICE);
    }

    @DisplayName("구매금액에 문자가 포함된 값 입력하여 실패")
    @Test
    void testInputNotNumber() {
        String input = "1,000";

        assertThatThrownBy(() -> new PurchaseAmount(input)).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구매금액에 0원 입력하여 실패")
    @Test
    void testInput0() {
        String input = "0";

        assertThatThrownBy(() -> new PurchaseAmount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INPUT_UNIT);
    }

    @DisplayName("구매금액에 천원단위가 아닌 값 입력하여 실패")
    @Test
    void testInputWrongUnit() {
        String input = "1001";

        assertThatThrownBy(() -> new PurchaseAmount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INPUT_UNIT);
    }

}