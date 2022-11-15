package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @DisplayName("0미만일 경우 에러를 반환한다.")
    @Test
    void createMoneyLessOne() {
        assertAll(
                () -> assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class),
                () -> assertDoesNotThrow(() -> new Money(0))
        );
    }

    @DisplayName("수익률을 구한다.")
    @Test
    void calculateYield() {
        assertThat(Money.yield(new Money(8000), new Money(5000))).isEqualTo(62.5);
    }

    @DisplayName("투자 원금이 0이면 에러를 반환한다.")
    @Test
    void calculateYieldInvestPrincipalZero() {
        assertThatThrownBy(() -> Money.yield(new Money(0), new Money(5000)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈을 더해 반환한다.")
    @Test
    void add() {
        Money money = new Money(5000);

        assertThat(money.add(new Money(1000))).isEqualTo(new Money(6000));
    }

    @DisplayName("돈을 나눈 값을 반환한다.")
    @Test
    void divide() {
        Money money = new Money(5000);

        assertThat(money.divideValue(new Money(1000))).isEqualTo(5);
    }

    @DisplayName("돈을 0으로 나누면 에러를 반환한다.")
    @Test
    void divideZero() {
        Money money = new Money(5000);

        assertThatThrownBy(() -> money.divideValue(new Money(0))).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "Money 값을 반환한다.")
    @ValueSource(longs = {1000L, 124000L, 12345678900L})
    void value(long value) {
        assertThat(new Money(value).value()).isEqualTo(value);
    }

    @DisplayName("0원인지 반환한다.")
    @Test
    void notZero() {
        Assertions.assertAll(
                () -> assertThat(new Money(0).notZero()).isFalse(),
                () -> assertThat(new Money(20000).notZero()).isTrue()
        );
    }
}
