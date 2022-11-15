package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("돈에 숫자말고 다른 문자가 포함되어 있다면 예외가 발생한다.")
    void createMoneyNotUsingNumber() {
        assertThatThrownBy(() -> new Money("100a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈이 1000원 단위로 나누어떨어지지 않는다면 예외가 발생한다.")
    void createMoneyNotDivideInto1000() {
        assertThatThrownBy(() -> new Money("10001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}