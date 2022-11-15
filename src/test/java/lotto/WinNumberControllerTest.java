package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinNumberControllerTest {
    WinNumberController wc = new WinNumberController();

    @DisplayName("문자열을 입력받아 숫자가 아닐시 예외 발생")
    @Test
    void isWinNumberValid() {
        assertThatThrownBy(() -> wc.readWinNumber("당첨 번호"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> wc.readBonusNumber("보너스"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
