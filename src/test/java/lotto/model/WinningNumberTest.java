package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    void validate_SizeNotSixInput_Fail() {
        assertThatThrownBy(() -> new WinningNumbers(Arrays.asList(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
    }

    @Test
    void getWinningNumbers_validInput_Success() {
        WinningNumbers wn = new WinningNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(wn.getWinningNumbers())
                .isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}