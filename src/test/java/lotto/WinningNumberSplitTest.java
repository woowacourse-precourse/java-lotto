package lotto;

import static lotto.utils.ErrorMessage.NOT_NUMBER_ERROR;
import static lotto.utils.ErrorMessage.WINNING_INPUT_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.utils.WinningNumberSplit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumberSplitTest {
    @DisplayName("당첨번호 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,,4", ",1,2,3,4,5"})
    void invalidInput(String input) {
        assertThatThrownBy(() -> WinningNumberSplit.splitWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(WINNING_INPUT_NUMBER_ERROR));
    }

    @DisplayName("당첨번호 입력 공백 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1    ,2,3,4,5,6", "1,20 , 3,4,5 ,6"})
    void invalidWhiteSpace(String input) {
        assertThatThrownBy(() -> WinningNumberSplit.splitWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                        String.valueOf(NOT_NUMBER_ERROR));
    }
}
