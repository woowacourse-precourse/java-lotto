package lotto.model.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @DisplayName("정상적인 당첨번호를 생성하는 경우")
    @Test
    void WinningNumber() {
        String validWinningNumber = "1,2,3,4,5,6";
        String validWinningNumber2 = " 1 , 2 , 3 , 4 , 5 , 6 ";
        String validBonusNumber = "7";
        String validBonusNumber2 = " 7 ";

        Assertions.assertThatCode(() -> new WinningNumber(validWinningNumber, validBonusNumber))
                .doesNotThrowAnyException();
        Assertions.assertThatCode(() -> new WinningNumber(validWinningNumber2, validBonusNumber2))
                .doesNotThrowAnyException();
    }

    @DisplayName("비정상적인 당첨번호를 생성하는 경우 예외처리")
    @Test
    void WinningNumberException() {
        String WrongWinningNumberForm = "1,2,,3,4,5,6";
        String WrongWinningNumberForm2 = "1,2,3,4,5";
        String validBonusNumber = "7";

        Assertions.assertThatThrownBy(() -> new WinningNumber(WrongWinningNumberForm, validBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new WinningNumber(WrongWinningNumberForm2, validBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}