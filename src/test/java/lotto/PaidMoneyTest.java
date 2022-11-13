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

}
