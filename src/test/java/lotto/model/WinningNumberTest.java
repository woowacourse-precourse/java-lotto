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

    @Test
    @DisplayName("숫자와 ',' 이외의 문자가 들어오는 경우 예외 발생")
    void createWinningNumber_Exception1() {
        // Given
        String winningNumberStr = "1,2,3,4,5,6j";
        String bonusNumberStr = "7";

        // When // Then
        assertThatThrownBy(() -> new WinningNumber(winningNumberStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1~45 범위의 숫자가 들어오는 경우 예외 발생")
    void createWinningNumber_Exception2() {
        // Given
        String winningNumberStr = "1,2,3,4,5,46";
        String bonusNumberStr = "7";

        // When // Then
        assertThatThrownBy(() -> new WinningNumber(winningNumberStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 들어오는 경우 예외 발생")
    void createWinningNumber_Exception3() {
        // Given
        String winningNumberStr = "1,2,3,4,5,6";
        String bonusNumberStr = "6";

        // When // Then
        assertThatThrownBy(() -> new WinningNumber(winningNumberStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class);
    }



    @Test
    @DisplayName("당첨번호 크기가 6이 아닌 경우 예외 발생")
    void createWinningNumber_Exception4() {
        // Given
        String winningNumberStr = "1,2,3,4,5,6,7";
        String bonusNumberStr = "8";

        // When // Then
        assertThatThrownBy(() -> new WinningNumber(winningNumberStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("bonusNumber에 숫자 이외의 문자가 들어오는 경우 예외 발생")
    void createWinningNumber_Exception5() {
        // Given
        String winningNumberStr = "1,2,3,4,5,6";
        String bonusNumberStr = "6j";

        // When // Then
        assertThatThrownBy(() -> new WinningNumber(winningNumberStr, bonusNumberStr))
            .isInstanceOf(IllegalArgumentException.class);
    }
}