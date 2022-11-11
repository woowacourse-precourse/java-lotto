package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinnerTest {
//    @DisplayName("당첨 번호 입력 시 쉼표를 사용하지 않으면 예외가 발생한다.")
//    @ParameterizedTest
//    @CsvSource(value = {"1.2.3.4.5.6:45", "12345,6:45", "1&2&3&4&5&6:45", "1+2+3+4+5+6:45", "12345and6:45"},
//            delimiter = ':')
//    void winningNumbersWithoutComma(String winningNumbers, String bonusNumber) {
//        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분됩니다.");
//    }
//
//    @DisplayName("당첨 번호 입력 시 숫자를 올바르게 쓰지 않으면 예외가 발생한다.")
//    @ParameterizedTest
//    @CsvSource(value = {"1,2,3,4,5, 6:45", "1,!!,3,4,5,6:45", "하나,2,3,4,5,6:45", "one,2,3,4,5,6:45"},
//            delimiter = ':')
//    void winningNumbersWithoutPropervalue(String winningNumbers, String bonusNumber) {
//        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 숫자 이외의 값이 입력되었습니다. 문자나 띄어쓰기 등이 들어갔는지 확인해주세요.");
//    }
//
//    @DisplayName("보너스 번호 입력 시 숫자를 올바르게 쓰지 않으면 예외가 발생한다.")
//    @Test
//    void inValidBonusNumber() {
//        String winningNumbers = "1,2,3,4,5,6";
//        String bonusNumber = "seven";
//
//        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 숫자 이외의 값이 입력되었습니다. 문자나 띄어쓰기 등이 들어갔는지 확인해주세요.");
//    }
//
//    @DisplayName("보너스 번호 입력 시 1에서 45 사이의 숫자를 입력하지 않으면 예외가 발생한다.")
//    @Test
//    void bonusNumberOutOfRange() {
//        String winningNumbers = "1,2,3,4,5,6";
//        String bonusNumber = "46";
//
//        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자들로 이루어져야 합니다.");
//    }
//
//    @DisplayName("보너스 번호 입력 시 당첨 번호와 겹치면 예외가 발생한다.")
//    @Test
//    void bonusNumberIncludedInWinningNumbers() {
//        String winningNumbers = "1,2,3,4,5,6";
//        String bonusNumber = "6";
//
//        assertThatThrownBy(() -> new Winner(winningNumbers, bonusNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 겹치는 번호가 존재합니다.");
//    }
}