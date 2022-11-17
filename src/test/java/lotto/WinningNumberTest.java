package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberTest {
    @DisplayName("보너스번호가 중복이면 예외를 던진다.")
    @Test
    public void bonusNumberAlreadyExists() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호가 당첨 번호와 중복됩니다.");
    }

    @DisplayName("보너스번호가 범위를 벗어나면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {55, 0, 100})
    public void throwExceptionWhenBonusNumberIsOutOfRange(int bonusNumber) {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 2, 3, 4, 5, 6), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호의 범위가 유효하지 않습니다.");
    }
}