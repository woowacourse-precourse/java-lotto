package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyerTest {
    @DisplayName("구매 금액 지불 시 1,000원 단위로 지불하지 않은 경우 예외가 발생한다.")
    @Test
    void 구매_금액_지불_단위_예외() {
        String input = "10500";
        assertThatThrownBy(() -> LottoBuyer.getInstance.checkPayUnit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액_숫자가_아닐_경우_예외() {
        String input = "12a00";
        assertThatThrownBy(() -> LottoBuyer.getInstance.checkOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
