package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("돈을 나눈 값을 반환한다.")
    @Test
    void divide() {
        Money money = new Money(5000);

        assertThat(money.divide(new Money(1000))).isEqualTo(5);
    }
}
