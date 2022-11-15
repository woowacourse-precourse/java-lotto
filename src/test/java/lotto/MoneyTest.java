package lotto;

import lotto.domain.Lotto;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("로또 구입 금액이 1000 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyBy() {
        assertThatThrownBy(() -> new Money(1300))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
