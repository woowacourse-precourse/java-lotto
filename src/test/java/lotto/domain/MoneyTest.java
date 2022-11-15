package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입 금액이 정상적으로 입력된 경우")
    @Test
    void inputCorrectMoney() {
        int money = new Money("8000").getMoney();
        assertThat(money).isEqualTo(8000);
    }

    @DisplayName("구입 금액이 0원인 경우")
    @Test
    void inputZeroMoney() {
        assertThatThrownBy(() -> new Money("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 정수가 아닌 경우")
    @Test
    void inputNotInteger() {
        assertThatThrownBy(() -> new Money("800as"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 음의 정수인 경우")
    @Test
    void inputNegativeInteger() {
        assertThatThrownBy(() -> new Money("-8000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않는 경우")
    @Test
    void inputNonLottoMoney() {
        assertThatThrownBy(() -> new Money("8001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
