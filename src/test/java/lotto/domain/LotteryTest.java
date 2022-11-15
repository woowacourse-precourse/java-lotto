package lotto.domain;

import controller.Lottery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.Calculator;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {

    @DisplayName("로또 구매 횟수만큼 로또를 가지고 있지 않으면 예외가 발생한다.")
    @Test
    void 로또리스트크기_예외발생() {
        Lottery lottery = new Lottery();
        int quantity = Calculator.getQuantity("8000");
        assertThat(lottery.getLottos(quantity).size()).isEqualTo(quantity);
    }
}
