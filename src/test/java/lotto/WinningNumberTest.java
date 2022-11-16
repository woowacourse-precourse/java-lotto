package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @DisplayName("당첨 번호가 1과 45사이의 값이 아니면 예외가 발생한다")
    @Test
    void createNumberByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 7, 10, 24, 37, 46), 12))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개의 보너스 번호가 6개의 당첨 번호 중에 포함되어있으면 예외가 발생한다")
    @Test
    void createBonusNumberIncludedInWinningNumber() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 7, 10, 24, 37, 45), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다")
    @Test
    void createNumberByDuplicatedNumbers() {
        assertThatThrownBy(() -> new WinningNumber(List.of(1, 7, 10, 24, 37, 37), 12))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복이 없는 1과 45사이의 값이 들어가면 예외가 발생하지 않는다")
    @Test
    void createNumberByWithinRange() {
        assertThatNoException()
                .isThrownBy(() -> new WinningNumber(List.of(1, 7, 10, 24, 37, 45), 12));
    }

    @DisplayName("당첨 번호에 입력 값이 포함되어 있으면 true를 반환한다")
    @Test
    void isContainNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 43), 45);

        boolean contain = winningNumber.isContainedInWinningNumber(10);

        assertThat(contain).isEqualTo(true);
    }

    @DisplayName("당첨 번호에 입력 값이 포함되어 있지 않으면 false를 반환한다")
    @Test
    void isNotContainNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 43), 45);

        boolean contain = winningNumber.isContainedInWinningNumber(11);

        assertThat(contain).isEqualTo(false);
    }

    @DisplayName("입력된 번호가 보너스 번호와 같으면 true를 반환한다")
    @Test
    void isEqualBonusNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 43), 45);

        boolean contain = winningNumber.isEqualToBonusNumber(45);

        assertThat(contain).isEqualTo(true);
    }

    @DisplayName("입력된 번호가 보너스 번호와 같지 않으면 false를 반환한다")
    @Test
    void isNotEqualBonusNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 43), 45);

        boolean contain = winningNumber.isEqualToBonusNumber(43);

        assertThat(contain).isEqualTo(false);
    }
}
