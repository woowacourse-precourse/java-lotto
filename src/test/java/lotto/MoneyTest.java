package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("구입금액은 정수형 숫자여야 한다.")
    @Test
    void inputMoneyByFloat() {
        assertThatThrownBy(() -> new Money("123.0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액에 문자를 입력하면 예외가 발생한다.")
    @Test
    void inputMoneyByString() {
        assertThatThrownBy(() -> new Money("52g12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액은 1000 이상의 정수형 숫자여야 한다.")
    @Test
    void inputMoneyByUnder1000() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액은 1000으로 나누어 떨어져야 한다.")
    @Test
    void inputMoneyNotDivided1000() {
        assertThatThrownBy(() -> new Money("4500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
