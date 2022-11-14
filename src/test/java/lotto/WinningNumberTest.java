package lotto;

import lotto.model.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 값이 45보다 큰 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverLimit() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 값이 1보다 작은 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderLimit() {
        assertThatThrownBy(() -> new WinningNumber("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 규격 이외의 값이 들어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByInvalidValue() {
        assertThatThrownBy(() -> new WinningNumber("이상한값"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
