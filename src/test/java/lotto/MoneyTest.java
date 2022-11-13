package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.utils.ErrorMessages.*;
import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"!000", "1000A"})
    void createMoneyByNotInteger(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_NOT_INTEGER);
    }

    @DisplayName("구입 금액이 1000보다 작으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "-2000"})
    void createMoneyByOutOfRange(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_OUT_OF_RANGE);
    }

    @DisplayName("구입 금액이 1000원 단위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1100", "5500", "100000001"})
    void createMoneyByNotDivideUnit(String money) {
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_NOT_DIVIDE_UNIT);
    }

    @DisplayName("구입 금액을 정수형으로 변환한다.")
    @ParameterizedTest
    @CsvSource({"1000,1000", "10000,10000", "7000,7000"})
    void MoneyToInteger(String inputMoney, int expected) {
        Money money = new Money(inputMoney);
        assertThat(money.getMoney()).isEqualTo(expected);
    }
}
