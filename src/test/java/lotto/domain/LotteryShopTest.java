package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryShopTest {
    @DisplayName("로또카운팅 테스트")
    @Test
    void countLottoTest() {
        LotteryShop lotteryShop = new LotteryShop();
        int lottoCnt = lotteryShop.countLotto(200000);
        Assertions.assertThat(lottoCnt).isEqualTo(200);
    }

    @DisplayName("구매 금액이 부족하면 예외가 발생한다.")
    @Test
    void validateByLackOfMoney() {
        LotteryShop lotteryShop = new LotteryShop();
        assertThatThrownBy(() -> lotteryShop.countLotto(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액과 나누어 떨어지지 않는 구매 금액이면 예외가 발생한다.")
    @Test
    void validateByNotDivided() {
        LotteryShop lotteryShop = new LotteryShop();
        assertThatThrownBy(() -> lotteryShop.countLotto(19534))
                .isInstanceOf(IllegalArgumentException.class);
    }


}