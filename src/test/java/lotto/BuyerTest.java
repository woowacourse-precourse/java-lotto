package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {

    Buyer buyer = new Buyer();

    @DisplayName("금액이 1000원 미만이면 예외 발생.")
    @Test
    void 금액미달() {
        assertThatThrownBy(() ->  buyer.validateMoneyRange(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위가 아니면 예외 발생.")
    @Test
    void 단위오류() {
        assertThatThrownBy(() -> buyer.validateMoneyUnit(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액에 숫자가 아닌 문자가 입력되면 예외 발생.")
    @Test
    void 금액입력오류() {
        assertThatThrownBy(() ->  buyer.validateMoneyOnlyNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
