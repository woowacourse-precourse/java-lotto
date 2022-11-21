package lotto;

import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    final WinningNumber winningNumber = new WinningNumber();

    @DisplayName("당첨 번호가 숫자와 쉼표로 구성되어있지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumberByLetter() {
        assertThatThrownBy(() -> winningNumber.saveWinningNumber("1 2 3 4 5"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void createBonusByLetter() {
        assertThatThrownBy(()-> winningNumber.checkBonus("abc"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("보너스 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void createBonusNotBetweenRange() {
        assertThatThrownBy(()-> winningNumber.checkBonus("46"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusByDuplicateNumber() {
        assertThatThrownBy(()-> winningNumber.validateDuplicateBonus(1,Arrays.asList(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("당첨 번호가 1부터 45 사이가 아니면 예외가 발생한다.")
    @Test
    void creatWinningNumberNotBetweenRange() {
        assertThatThrownBy(()-> winningNumber.saveWinningNumber("1,2,3,4,5,0"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("당첨 번호가 중복이면 예외가 발생한다.")
    @Test
    void creatWinningNumberByDuplicateNumber() {
        assertThatThrownBy(()-> winningNumber.saveWinningNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);

    }
    @DisplayName("당첨 번호는 쉼표로 나눈다.")
    @Test
    void divideWinningNumberByComma() {
        List<Integer> winnings = winningNumber.saveWinningNumber("1,2,3,4,5,6");
        assertThat(winnings.equals(Arrays.asList(1,2,3,4,5,6)));
    }
}
