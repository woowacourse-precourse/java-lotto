package lotto.input;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void validate_notCommaInput_Fail() {
        assertThatThrownBy(() -> WinningNumber.validate("1-2-3-4-5-6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 콤마(',')로 숫자를 이어서 입력해야 합니다.");
    }

    @Test
    void validate_SizeNotSixInput_Fail() {
        assertThatThrownBy(() -> WinningNumber.validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
    }

    @Test
    void validate_NotNumberInput_Fail() {
        assertThatThrownBy(() -> WinningNumber.validate("1,2,3,4,a,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 숫자여야 합니다.");
    }

    @Test
    void getWinningNumbers() {
        assertThat(WinningNumber.getWinningNumbers("1,2,3,4,5,6"))
                .isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}