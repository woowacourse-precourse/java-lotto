package lotto.bo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberTest {
    @DisplayName("당첨 번호에 문자가 들어갈 시 예외가 발생한다.")
    @Test
    void createWinningNumberByNotInteger() {
        assertThatThrownBy(() -> new WinningNumber("1,ad,324,12,3","2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}