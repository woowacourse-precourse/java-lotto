package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCostTest {
    @DisplayName("로또구매 금액이 1000원으로 나누어 떨어지지 않는다면 예외가 발생한다.")
    @Test
    void createLottoCostByDivide() {
        assertThatThrownBy(() -> new LottoCost(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또구매 금액이 0원 이라면 예외가 발생한다.")
    @Test
    void createLottoCostByCorrectRange() {
        assertThatThrownBy(() -> new LottoCost(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
