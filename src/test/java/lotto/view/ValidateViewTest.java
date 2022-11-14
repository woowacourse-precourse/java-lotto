package lotto.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidateViewTest {

    @DisplayName("money가 1000으로 나누어 안떨어지는지, 1000 이상인지")
    @ParameterizedTest
    @ValueSource(ints = {1500})
    void inputMoneyByWrongNumber(int input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ValidateView.isPossibleMoney(input);
        });
    }

    @DisplayName("변환하려는 문자가 숫자 타입이 맞는지")
    @ParameterizedTest
    @ValueSource(strings = {"15A"})
    void inputNumberByWrongType(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ValidateView.possibleNumber(input);
        });
    }

    @DisplayName("bonusNumber가 1부터 45까지 숫자가 맞는지")
    @ParameterizedTest
    @ValueSource(ints = {46})
    void inputBonusNumberByWrongNumber(int input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ValidateView.isPossibleBonusNumber(input);
        });
    }
}
