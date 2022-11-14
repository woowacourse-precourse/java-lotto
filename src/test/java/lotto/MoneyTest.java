package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    void purchaseLotto() {
        Money money = new Money(8000);
        int result = money.purchase();
        assertThat(result).isEqualTo(8);

        Money money2 = new Money(7500);
        int result2 = money2.purchase();
        assertThat(result2).isEqualTo(7);
    }

    @DisplayName("돈이 1000원이면 예외가 발생한다.")
    @Test
    void purchaseLotto_1000원미만() {
        assertThatThrownBy(() -> new Money(900)).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR]");
    }
}
