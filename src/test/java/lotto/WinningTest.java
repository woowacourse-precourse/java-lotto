package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.system.SystemValid;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTest {

    @DisplayName("당첨 번호 입력 형식이 맞지않다면 예외가 발생한다.")
    @Test
    void createSystemValidByWinningNumberRegex() {
        String input = "1,2,3,";
        assertThatThrownBy(() -> SystemValid.validateForWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 중복이 발생하면 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedNumbers() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 2, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스번호가 중복이 발생하면 예외가 발생한다.")
    @Test
    void createWinningByDuplicatedNumbersAndBonusNumber() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningByNumbersOverSize() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개 미만이면 예외가 발생한다.")
    @Test
    void createWinningByNumbersUnderSize() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 지정된 숫자 범위안에 존재하지 않는다면 예외가 발생한다.")
    @Test
    void createWinningByNumbersBetweenValue() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 60), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 지정된 숫자 범위안에 존재하지 않는다면 예외가 발생한다.")
    @Test
    void createWinningByBonusNumbersBetweenValue() {
        assertThatThrownBy(() -> new Winning(List.of(1, 2, 3, 4, 5, 6), 71))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

