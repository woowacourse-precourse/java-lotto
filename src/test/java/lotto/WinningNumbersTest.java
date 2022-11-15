package lotto;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1보다 작은 숫자가 있으면 예외가 발생한다.")
    void createWinningNumberBySmallNumber() {
        assertThatThrownBy(() -> new WinningNumbers("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("45보다 큰 숫자가 있으면 예외가 발생한다.")
    void createWinningNumberByLargeNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    void createBonusNumberByNotNumber() {
        assertThatThrownBy(() -> winningNumbers.chooseBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호의 범위가 벗어나면 예외가 발생한다.")
    void createBonusNumberByLargeNumber() {
        assertThatThrownBy(() -> winningNumbers.chooseBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    void createBonusNumberByDuplicated() {
        assertThatThrownBy(() -> winningNumbers.chooseBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
