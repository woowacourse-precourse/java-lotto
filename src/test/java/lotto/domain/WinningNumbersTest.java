package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {
    @DisplayName("당첨번호와 보너스 번호가 다르면, 예외가 발생하지 않는다")
    @Test
    void createValidWinningNumber() {
        assertThatCode(()-> new WinningNumbers(List.of(2,12,14,22,29,34), 3))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨번호와 보너스 번호가 같으면 예외가 발생한다.")
    @Test
    void createWinningNumberContainBonusNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복된 수가 존재하면 예외가 발생한다.")
    @Test
    void createDuplicateWinningNumber() {
        assertThatThrownBy(()-> new WinningNumbers(List.of(1,2,3,4,4,5), 12) )
                .isInstanceOf(IllegalArgumentException.class);
    }
}