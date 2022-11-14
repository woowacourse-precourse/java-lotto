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

}
