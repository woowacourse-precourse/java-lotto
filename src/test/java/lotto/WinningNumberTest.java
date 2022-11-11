package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @DisplayName("당첨 번호의 크기가 6보다 크면 예외가 발생한다.")
    @Test
    void createWinningNumSizeBiggerThan6() {
        List<Integer> winningNum = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(() -> new WinningNumber(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 길이가 6보다 작으면 예외가 발생한다.")
    @Test
    void createWinningNumSizeSmallerThan6() {
        List<Integer> winningNum = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new WinningNumber(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1-45 사이의 수가 아닌 수가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createWinningNumNotInRange() {
        List<Integer> winningNum = List.of(1, 2, 3, 46, 5, 6);
        assertThatThrownBy(() -> new WinningNumber(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 수가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createWinningNumNotUnique() {
        List<Integer> winningNum = List.of(1, 2, 3, 3, 5, 6);
        assertThatThrownBy(() -> new WinningNumber(winningNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 1-45 사이의 수가 아닌 수가 포함되어 있으면 예외가 발생한다.")
    @Test
    void createBonusNumNotInRange() {
        int bonusNum = 98;
        assertThatThrownBy(() -> new WinningNumber(bonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

}