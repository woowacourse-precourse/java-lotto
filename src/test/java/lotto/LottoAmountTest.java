package lotto;

import lotto.model.LottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoAmountTest {

    @DisplayName("돈이 로또 한 장의 가격보다 부족한 경우 예외를 발생한다.")
    @Test
    void createShortMoney() {
        assertThatThrownBy(() -> new LottoAmount(10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또를 구매하고 거스름 돈이 남는 경우 예외를 발생한다.")
    @Test
    void createRemainMoney() {
        assertThatThrownBy(() -> new LottoAmount(11111))
                .isInstanceOf(IllegalArgumentException.class);
    }
}