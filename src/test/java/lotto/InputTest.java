package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {
    @DisplayName("구입금액에 문자열이 입력되면 예외가 발생한다.")
    @Test
    void stringToIntMoneyByNonNumericInput() {
        assertThatThrownBy(() -> Input.stringToIntMoney("o12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void stringToIntMoneyByOtherThanThousandWon() {
        assertThatThrownBy(() -> Input.stringToIntMoney("15400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 구분자가 쉼표(,)가 아니면 예외가 발생한다.")
    @Test
    void winningNumberNotSeparatedByCommas() {
        assertThatThrownBy(() -> Input.createWinningLotto("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 문자가 입력되면 예외가 발생한다.")
    @Test
    void winningNumberWithString() {
        assertThatThrownBy(() -> Input.createWinningLotto("1,2,3,b,a,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void winningNumberNotInRange() {
        assertThatThrownBy(() -> Input.createWinningLotto("46,47,48,49,50,51"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void winningNumberWithDuplicatedNumber() {
        assertThatThrownBy(() -> Input.createWinningLotto("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45를 벗어나면 예외가 발생한다.")
    @Test
    void bonusNumberNotInRange() {
        assertThatThrownBy(() -> Input.checkBonusValidation("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}