package lotto;

import lotto.domain.Bonus;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MoneyTest {

    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void createMoneyByNotDivided() {
        assertThatThrownBy(() -> new Money(777))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 0원 이하면 예외가 발생한다.")
    @Test
    void createMoneyByNegative() {
        assertThatThrownBy(() -> new Money(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 금액 입력시 예외가 발생하지 않는다.")
    @Test
    void createMoneyBySuccess() {
        assertDoesNotThrow(() -> new Money(3000));
    }
}
