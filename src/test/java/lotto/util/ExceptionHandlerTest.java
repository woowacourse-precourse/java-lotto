package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class ExceptionHandlerTest {

    List<Integer> lottoNumbers = List.of(1,2,3,4,5,6);

    @DisplayName("올바른 구입금액 입력")
    @Test
    void checkValidationMoneyTest() {
        String input = "1000";
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkValidationMoney(input));
    }

    @DisplayName("잘못된 구입금액 입력")
    @Test
    void checkValidationMoneyTest_Exception() {
        String[] inputs = {"100", "1001", "100100", "aa"};
        for (String input : inputs) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> ExceptionHandler.checkValidationMoney(input));
        }
    }

    @DisplayName("올바른 당첨번호 입력")
    @Test
    void checkValidationWinningNumberTest() {
        String input = "1,2,3,4,5,6";
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }

    @DisplayName("당첨번호에 콤마가 아닌 구분자 입력한 경우")
    @Test
    void checkValidationWinningNumberTest_Not_Comma() {
        String input = "1,2,3.4,5,6";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }

    @DisplayName("당첨번호에 문자가 들어간 경우")
    @Test
    void checkValidationWinningNumberTest_Contains_Character() {
        String input = "1,2,3,a,5,6";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }

    @DisplayName("당첨번호에 중복된 숫자가 입력된 경우")
    @Test
    void checkValidationWinningNumberTest_SameNumber() {
        String input = "1,2,3,4,5,5";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationWinningNumber(input));
    }

    @DisplayName("올바른 보너스번호 입력")
    @Test
    void checkValidationBonusNumberTest() {
        String input = "7";
        assertThatNoException()
                .isThrownBy(() -> ExceptionHandler.checkValidationBonusNumber(input, lottoNumbers));
    }

    @DisplayName("당첨 번호와 중복되는 숫자 입력한 경우")
    @Test
    void checkValidationBonusNumberTest_Contains_WinningNumbers() {
        String input = "6";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationBonusNumber(input, lottoNumbers));
    }

    @DisplayName("보너스 번호에 문자가 입력된 경우")
    @Test
    void checkValidationBonusNumberTest_Contains_Character() {
        String input = "a";
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExceptionHandler.checkValidationBonusNumber(input, lottoNumbers));
    }

}
