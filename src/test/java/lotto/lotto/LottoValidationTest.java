package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidationTest {
    @DisplayName("당첨 번호와 보너스 번호가 중복될 시 예외 처리")
    @Test
    void validateByDuplicatedWinningWithBonus() {
        assertThatThrownBy(() -> LottoValidation.validateUniqueWinningNumbersWithBonus(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto가 중복된 수를 가지고 있다면 예외처리")
    @Test
    void validateByDuplicatedNumbers() {
        assertThatThrownBy(() -> LottoValidation.validateUniqueNumbers(List.of(2, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto가 범위를 넘어선 수를 가지고 있다면 예외처리")
    @Test
    void validateByOverSizeNumber() {
        assertThatThrownBy(() -> LottoValidation.validateRange(List.of(46, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}