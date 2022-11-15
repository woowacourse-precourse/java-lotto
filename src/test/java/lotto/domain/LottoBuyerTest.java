package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyerTest {
    @DisplayName("구매 금액 지불 시 1,000원 단위로 지불하지 않은 경우 예외가 발생한다.")
    @Test
    void 구매_금액_지불_단위_예외() {
        String input = "10500";

        assertThatThrownBy(() -> LottoBuyer.getInstance.getPay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구매 금액은 1,000 단위로만 입력 가능합니다.");
    }

    @DisplayName("구매 금액이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 구매_금액_숫자가_아닐_경우_예외() {
        String input = "12a00";
        assertThatThrownBy(() -> LottoBuyer.getInstance.getPay(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }
}
