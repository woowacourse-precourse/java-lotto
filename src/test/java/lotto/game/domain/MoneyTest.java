package lotto.game.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("입력된 금액이 숫자가 아니면 에외가 발생한다.")
    void createMoneyByNotInteger() {
        // given
        String input = "12삼";
        // expect
        assertThatThrownBy(() -> Money.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("입력된 금액이 1000으로 나눠떨어지지 않으면 예외가 발생한다")
    void createMoneyByNotDivisible1000() {
        // given
        String input = "12345";
        // expect
        assertThatThrownBy(() -> Money.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000으로 나눠 떨어지는 금액만 입력해주세요.");
    }

    @Test
    @DisplayName("입력된 금액이 정상적이면 돈을 반환한다.")
    void createMoney() {
        // given
        String input = "10000";
        Money money = Money.of(10000);

        // expect
        assertThat(Money.of(input))
                .isEqualTo(money);
    }
}