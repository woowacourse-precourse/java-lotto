package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("입력 형식이 \",\"로 나뉜 6개의 원소가 아니라면 예외를 반환한다.")
    @Test
    void createWinningNumberByUnderSize() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 원소에 숫자가 아닌 원소가 있다면 예외를 반환한다.")
    @Test
    void createWinningNumberByNoNumericElement() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, a, 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRangeNumber() {
        assertThatThrownBy(() -> new WinningNumber("1, 2, 3, 4, 5, 46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
