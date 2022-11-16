package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerTest {

    Buyer buyer = new Buyer();

    @DisplayName("금액이 1000원 미만이면 예외 발생.")
    @Test
    void checkLessMoney() {
        assertThatThrownBy(() ->  buyer.validateMoneyRange(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 단위가 아니면 예외 발생.")
    @Test
    void checkMoneyUnit() {
        assertThatThrownBy(() -> buyer.validateMoneyUnit(3500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액에 숫자가 아닌 문자가 입력되면 예외 발생.")
    @Test
    void checkMoneyType() {
        assertThatThrownBy(() ->  buyer.validateMoneyOnlyNumber("1000a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
