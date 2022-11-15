package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    @DisplayName("당첨 번호가 쉼표를 기준으로 6개로 나누어지지 않으면 예외가 발생한다.")
    @Test
    void createWinningNumbersNotSplitByComma() {
        assertThatThrownBy(() -> new WinningNumbers("1.2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers("100,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위를 벗어나는 문자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByOutOfRange2() {
        assertThatThrownBy(() -> new WinningNumbers("1a,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumbersByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", "-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위를 벗어나는 문자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumbersByOutOfRange2() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", "4ㅅ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5", "7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateNumber() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}