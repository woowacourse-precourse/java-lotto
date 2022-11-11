package lotto.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @DisplayName("당첨 번호에 문자가 들어갈 시 예외가 발생한다.")
    @Test
    void createWinningNumberByNotInteger() {
        assertThatThrownBy(() -> new WinningNumber("1,ad,324,12,3,7","2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1 ~ 45의 숫자가 아닐 시 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRangeNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,324,12,3,6","2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개의 숫자가 아니면 에러가 발생한다.")
    @Test
    void createWinningNumberByInvalidSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,324,12,3","2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}