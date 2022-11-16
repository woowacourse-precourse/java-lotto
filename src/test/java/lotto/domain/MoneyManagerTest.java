package lotto.domain;

import lotto.util.ResultPrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static lotto.util.ResultPrice.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyManagerTest {

    private static final Map<ResultPrice, Integer> totalScore = Map.of(
            FIRST, 0,
            SECOND, 0,
            THIRD, 0,
            FOURTH, 0,
            FIFTH, 1

    );

    @ParameterizedTest(name = "숫자가 아닌 값이 오면 예외발생")
    @CsvSource(value = {"1000j", "asdf", "돈입니다"})
    void getMoneyReturn(String money) {
        assertThatThrownBy(() -> new MoneyManager(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "금액이 1000으로 나누어떨어지지않으면 예외가 발생한다.")
    @CsvSource(value = {"1001", "999", "123", "2003"})
    void createLottoByInvalidMoney(String money) {
        assertThatThrownBy(() -> new MoneyManager(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}으로 5등 1개가 당첨되면 수익률은 {1}%")
    @CsvSource(value = {"1000:500", "2000:250", "4000:125", "8000:62.5"}, delimiter = ':')
    void createMoneyReturn(String money, Double result) {
        MoneyManager moneyManager = new MoneyManager(money);
        Double moneyReturn = moneyManager.getMoneyReturn(totalScore);

        assertEquals(moneyReturn, result);
    }


}