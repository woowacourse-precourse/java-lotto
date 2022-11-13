package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    @DisplayName("입력한 당첨 번호 및 보너스 번호가 조건에 부합하는지")
    public void winningNumberTest() {
        String lottoNumbers = "2,3,4,5,6";
        String bonusNumbers = "7";
        WinningNumber wn = new WinningNumber(lottoNumbers, bonusNumbers);

        assertThatThrownBy(() -> new WinningNumber(lottoNumbers, bonusNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }
}