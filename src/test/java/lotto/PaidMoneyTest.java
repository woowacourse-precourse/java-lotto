package lotto;

import lotto.domain.PaidMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaidMoneyTest {
    @DisplayName("구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void createMoneyByNoMoney() {
        assertThatThrownBy(() -> new PaidMoney(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByWrongMoney() {
        assertThatThrownBy(() -> new PaidMoney(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
