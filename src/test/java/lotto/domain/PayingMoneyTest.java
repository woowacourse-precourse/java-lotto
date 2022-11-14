package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PayingMoneyTest {

    @DisplayName("정상적인 로또 구입 금액을 입력받는 경우")
    @Test
    void PayingMoney() {
        String validPayingMoney = "1000";
        String validPayingMoney2 = " 1 0 0 0 ";

        Assertions.assertThatCode(() -> new PayingMoney(validPayingMoney))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> new PayingMoney(validPayingMoney2))
                .doesNotThrowAnyException();
    }

    @DisplayName("비정상적인 로또 구입 금액을 입력받는 경우 예외처리")
    @Test
    void PayingMoneyException() {
        String notNumberPayingMoney = "a";
        String notNumberPayingMoney2 = "a2";
        String invalidRangePayingMoney = "0";
        String notFactorOf1000PayingMoney = "1999";

        Assertions.assertThatThrownBy(() -> new PayingMoney(notNumberPayingMoney))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new PayingMoney(notNumberPayingMoney2))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new PayingMoney(invalidRangePayingMoney))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new PayingMoney(notFactorOf1000PayingMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }
}