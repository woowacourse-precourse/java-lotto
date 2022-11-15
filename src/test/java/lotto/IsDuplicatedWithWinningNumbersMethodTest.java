package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import lotto.Application.NumberType;
import static lotto.Application.numberType;
import static lotto.Application.initializeNumberType;
import static lotto.Application.isDuplicatedWithWinningNumbers;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsDuplicatedWithWinningNumbersMethodTest {
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호가 아닌 다른 번호를 입력하십시오.";
    ArrayList<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다.")
    @Test
    void isDuplicatedWithWinningNumbersMethodExceptionTest1() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        int bonusNumber = 1;
        assertThatThrownBy(() -> isDuplicatedWithWinningNumbers(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("당첨 번호와 보너스 번호가 다르면 예외가 발생하지 않는다.")
    @Test
    void isDuplicatedWithWinningNumbersMethodExceptionTest2() {
        initializeNumberType();
        for (int winningNumber : winningNumbers)
            numberType[winningNumber] = NumberType.WINNING;
        int bonusNumber = 7;
        isDuplicatedWithWinningNumbers(bonusNumber);
    }
}