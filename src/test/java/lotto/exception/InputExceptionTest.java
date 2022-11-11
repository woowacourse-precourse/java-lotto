package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {
    @DisplayName("입력된 금액 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3500", "4650", "9080", "10", "100", "1298089", "0", "100ki"})
    void validatePurchaseAmountTest(String money) {
        assertThatThrownBy(() -> InputException.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
    @DisplayName("입력된 당첨 번호 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,46", "1,2,3,4", "1,2,3,4,5,6,7,8,9", "1,1,2,2,3,4"})
    void validateWinningNumberTest(String numbers) {
        List<Integer> winningNumber = Arrays.stream(numbers.split(","))
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
        assertThatThrownBy(() -> InputException.validateWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
    @DisplayName("입력된 보너스 번호 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 13, 18, 22, 43, 55, 58, 89})
    void validateWinningNumberTest(int bonusNumber) {
        List<Integer> winningNumber = List.of(1, 5, 13, 18, 22, 43);
        assertThatThrownBy(() -> InputException.validateBonusNumber(bonusNumber, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}