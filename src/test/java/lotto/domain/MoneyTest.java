package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @ValueSource(ints = {1000, 2000, 10000, 15000})
    @ParameterizedTest
    void 구입금액을_생성한다(int money) {
        assertDoesNotThrow(() -> new Money(money));
    }

    @ValueSource(ints = {1001, 9999, 10001})
    @ParameterizedTest
    void 구입금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(ints = {-1, 0, 1, 999})
    @ParameterizedTest
    void 구입금액이_1000원보다_작으면_예외가_발생한다(int money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률을_계산한다() {
        Money money = new Money(2_000_000);

        assertThat(money.yield(1_345_000)).isEqualTo(67.3);
    }

    @Test
    void 구입금액으로_몇개의_로또를_살_수_있는지_계산한다() {
        Money money = new Money(2_000_000);

        assertThat(money.count()).isEqualTo(2_000);
    }
}
