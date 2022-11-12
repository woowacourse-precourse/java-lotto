package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBuyerTest {
    LottoBuyer lottoBuyer = new LottoBuyer();

    @DisplayName("구매 금액 지불 시 1,000원 단위로 지불하지 않은 경우 예외가 발생한다.")
    @Test
    void 구매_금액_지불_단위_예외() {
        int pay = 10_500;
        assertThatThrownBy(() -> lottoBuyer.checkPayUnit(pay))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
