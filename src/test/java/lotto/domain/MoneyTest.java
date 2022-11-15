package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @DisplayName("1000으로 나누어 떨어져야 한다.")
    @Test
    void createMoneyByNine() {
        assertThat(new Money().validate("9"))
                .isEqualTo(false);
    }

    @DisplayName("널이면 안된다.")
    @Test
    void createMoneyByNull() {
        assertThat(new Money().validate(""))
                .isEqualTo(false);
    }

    @DisplayName("1000으로 나누어 떨어지는 숫자로 생성 가능하다.")
    @Test
    void createMoneyByMillion() {
        assertThat(new Money().validate("10000"))
                .isEqualTo(true);
    }
}