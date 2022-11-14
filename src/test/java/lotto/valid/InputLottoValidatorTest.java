package lotto.valid;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputLottoValidatorTest {
    @DisplayName("로또 구입 금액 숫자가 아닐 경우 예외 처리")
    @Test
    void isDigitMoney() {
        String nonDigit = "70m6";

        InputLottoValidator inputLottoValidator = new InputLottoValidator();

        assertThatThrownBy(() -> new InputLottoValidator().validateMoney(nonDigit))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 쉼표로 구분되어 있지 않을 경우 예외 처리")
    @Test
    void  isDistinguishCommaWinningNumbers() {
        String distinguishDot = "1.2.3.4.5.6";
        String insufficientComma = "1,23,4,5,6";
        String excessiveComma = "1,2,3,4,5,6,";

        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(distinguishDot))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(insufficientComma))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(excessiveComma))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("당첨 번호가 숫자가 아닐 경우 예외 처리")
    @Test
    void isDigitWinningNumbers() {
        String nonDigit = "a,b,3,4,5,6";

        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(nonDigit))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 아닐 경우 예외 처리")
    @Test
    void checkCountWinningNumbers() {
        String insufficientNumber = "1,3,4,5,6";
        String excessiveNumber = "1,2,3,4,5,6,7";

        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(insufficientNumber))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(excessiveNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1부터 45 사이의 숫자가 아닐 경우 예외 처리")
    @Test
    void checkRangeWinningNumbers() {
        String overRangeNumber = "1,2,3,4,5,47";
        String underRangeNumber = "-1,2,3,4,5";

        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(overRangeNumber))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(underRangeNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복이 있을 경우 예외 처리")
    @Test
    void duplicateWinningNumbers() {
        String duplicationNumber = "1,2,3,3,4,5";

        assertThatThrownBy(() -> new InputLottoValidator().validateWinningNumbers(duplicationNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우 예외 처리")
    @Test
    void isDigitBonusNumber() {
        String nonDigitNumber = "a";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> new InputLottoValidator().validateBonusNumber(nonDigitNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1개가 아닐 경우 예외 처리")
    @Test
    void checkCountBonusNumber() {
        String insufficientNumber = "";
        String excessiveNumber = "1,3";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> new InputLottoValidator().validateBonusNumber(insufficientNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputLottoValidator().validateBonusNumber(excessiveNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아닐 경우 예외 처리")
    @Test
    void checkRangeBonusNumber() {
        String underRangeNumber = "-1";
        String overRangeNumber = "46";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> new InputLottoValidator().validateBonusNumber(underRangeNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputLottoValidator().validateBonusNumber(overRangeNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외 처리")
    @Test
    void duplicateBonusNumber() {
        String duplicationNumber = "5";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        assertThatThrownBy(() -> new InputLottoValidator().validateBonusNumber(duplicationNumber, winningNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

}