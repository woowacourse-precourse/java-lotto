package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호가 6개가 아닐 경우 실패")
    void winningNumbersSizeIsNotSixTest() {
        List<Integer> winningNumbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> winningNumbers2 = List.of(1, 2, 3);
        List<Integer> winningNumbers3 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> winningNumbers4 = List.of();
        int bonusNumber = 45;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers3, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers4, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호에 중복되는 번호가 있을 경우 실패")
    void winningNumbersContainDuplicateNumberTest() {
        List<Integer> winningNumbers1 = List.of(1, 2, 3, 3, 4, 5);
        List<Integer> winningNumbers2 = List.of(3, 3, 3, 3, 4, 5);
        List<Integer> winningNumbers3 = List.of(5, 1, 2, 3, 4, 5);
        int bonusNumber = 45;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers3, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호에 1~45의 범위를 벗어나는 수가 들어올 경우 실패")
    void winningNumberOutsideTheRangeOfOneToFortyFiveTest() {
        List<Integer> winningNumbers1 = List.of(-1, 2, 3, 4, 5, 7);
        List<Integer> winningNumbers2 = List.of(0, 2, 3, 4, 5, 7);
        List<Integer> winningNumbers3 = List.of(1, 2, 3, 4, 5, 46);
        List<Integer> winningNumbers4 = List.of(-1, 0, 3, 4, 5, 101);
        int bonusNumber = 45;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers1, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers2, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers3, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningLotto(winningNumbers4, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = {-4, 0, 46, 101, -45})
    @DisplayName("보너스 번호에 1~45의 범위를 벗어나는 수가 들어올 경우 실패")
    void bonusNumberOutsideTheRangeOfOneToFortyFiveTest(int bonusNumber) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복될 경우 실패")
    void duplicateWinningNumberAndBonusNumberTest() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 3;

        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
