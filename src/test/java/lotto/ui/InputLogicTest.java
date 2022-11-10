package lotto.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputLogicTest {
    @DisplayName("입력된 금액 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3500, 4650, 9080, 10, 100, 1298089, 0})
    void validatePurchaseAmountTest(int money) {
        String errorMessage = "[ERROR] 입력된 금액이 1000원 단위로 나눠 떨어져야 합니다.";
        if (money == 0) {
            errorMessage = "[ERROR] 입력된 금액이 0원보다는 커야 합니다.";
        }
        assertThatThrownBy(() -> InputLogic.validatePurchaseAmount(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining(errorMessage);
    }
    @DisplayName("입력된 당첨 번호 예외 발생 테스트 1")
    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,46", "1,2,3,4", "1,2,3,4,5,6,7,8,9", "1,1,2,2,3,4"})
    void validateWinningNumberTest_1(String numbers) {
        List<Integer> winningNumber = Arrays.stream(numbers.split(","))
                .map(number -> Integer.valueOf(number))
                .collect(Collectors.toList());
        assertThatThrownBy(() -> InputLogic.validateWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}