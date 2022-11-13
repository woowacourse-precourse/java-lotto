package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    @DisplayName("입력 받은 당첨 번호를 사용하여 WinningNumber 객체 생성 성공")
    void createWinningNumber_Success() {
        // Given
        String winningNumberStr = "1,2,3,4,5,6";
        String bonusNumberStr = "7";

        // When
        WinningNumber winningNumber = new WinningNumber(winningNumberStr, bonusNumberStr);

        // Then
        assertThat(winningNumber.getWinningNumbers()).containsOnly(1,2,3,4,5,6);
        assertThat(winningNumber.getBonusNumber()).isEqualTo(7);
    }
}