package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @Test
    @DisplayName("입력한 당첨 번호 및 보너스 번호의 개수가 맞는지")
    public void winningNumberCountTest() {
        String lottoNumbers = "1,2,3,4,5";
        String bonusNumbers = "7";
        WinningNumber wn = new WinningNumber(lottoNumbers, bonusNumbers);

        assertThatThrownBy(() -> new WinningNumber(lottoNumbers, bonusNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("입력한 당첨 번호 및 보너스 번호에 중복이 없는지")
    public void winningNumberDuplicateTest() {
        String lottoNumbers = "1,2,3,4,5,5";
        String bonusNumbers = "7";
        WinningNumber wn = new WinningNumber(lottoNumbers, bonusNumbers);

        assertThatThrownBy(() -> new WinningNumber(lottoNumbers, bonusNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }
}