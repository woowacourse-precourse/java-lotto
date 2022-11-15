package lotto;

import static lotto.Constants.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinnerTest {
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("보너스 번호 입력 시 1에서 45 사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 899, 1234})
    void bonusNumberOutOfRange(int number) {
        Integer bonusNumber = number;

        assertThatThrownBy(() -> new Winner(WINNING_NUMBERS, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_TITLE + OUT_OF_RANGE);
    }

    @DisplayName("보너스 번호 입력 시 당첨 번호와 겹치면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void bonusNumberIncludedInWinningNumbers(int number) {
        Integer bonusNumber = number;

        assertThatThrownBy(() -> new Winner(WINNING_NUMBERS, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_TITLE + DUPLICATE_NUMBERS);
    }
}