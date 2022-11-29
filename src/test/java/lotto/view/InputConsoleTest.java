package lotto.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputConsoleTest extends NsTest{

    InputConsole inputConsole;

    public InputConsoleTest() {
        this.inputConsole = new InputConsole();
    }

    @Test
    @DisplayName("view가 출력되고, 구입금액을 입력하면 입력값이 return되어야 한다.")
    void inputAmount() {
        // given
        run("8000");

        // when
        String input = inputConsole.enterPurchaseAmount();

        // then
        assertEquals("구입금액을 입력해 주세요.", output());
        assertEquals("8000", input);
    }

    @Test
    @DisplayName("구입금액을 null 입력시 IllegalArgumentException 에러메세지가 출력되어야 한다.")
    void inputAmountNull() {
        // given
        run("");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterPurchaseAmount);
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입금액을 whiteSpace 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputAmountWhiteSpace() {
        // given
        run(" ");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterPurchaseAmount);
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("구입금액을 숫자 이외의 값 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputAmountNotNumber() {
        // given
        run("숫자아님");

        // expected
        Exception exception = assertThrows(NoSuchElementException.class, inputConsole::enterPurchaseAmount);
        assertEquals("[ERROR] 숫자를 입력 하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("구입금액을 1000원 단위로 입력 하지 않을 시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputAmountNot1000Units() {
        // given
        run("12345");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterPurchaseAmount);
        assertEquals("[ERROR] 1,000원 단위로 입력 하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("구입금액을 21억 초과 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputAmountOver2Point1Billion() {
        // given
        run("2100001000");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterPurchaseAmount);
        assertEquals("[ERROR] 21억 이하로 입력하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호를 null 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputWinningNumberNull() {
        // given
        run("");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterWinningNumber);
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호를 whiteSpace 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputWinningWhiteSpace() {
        // given
        run(" ");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterWinningNumber);
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호를 숫자나 쉼표 이외의 값 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputWinningNotNumberOrComma() {
        // given
        run("1,2,3,사,five,6");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterWinningNumber);
        assertEquals("[ERROR] 숫자나 쉼표만 입력 해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호를 숫자 6개미만 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputWinningUnderSixNumbers() {
        // given
        run("1,2,3,4,5");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterWinningNumber);
        assertEquals("[ERROR] 6개의 숫자를 입력해 주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호를 숫자 6개초과 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputWinningUpSixNumbers() {
        // given
        run("1,2,3,4,5,6,7");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterWinningNumber);
        assertEquals("[ERROR] 6개의 숫자를 입력해 주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("당첨번호를 1~45이외의 숫자 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputWinningNot1To45() {
        // given
        run("1,2,3,4,5,50");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterWinningNumber);
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스번호를 null 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputBonusNull() {
        // given
        run("");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterBonusNumber);
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스번호를 whiteSpace 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputBonusWhiteSpace() {
        // given
        run(" ");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterBonusNumber);
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스번호를 숫자 이외의 값 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputBonusNotNull() {
        // given
        run("한글");

        // expected
        Exception exception = assertThrows(NoSuchElementException.class, inputConsole::enterBonusNumber);
        assertEquals("[ERROR] 숫자를 입력 하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("보너스번호를 1~45이외의 값 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputBonusNot1To45() {
        // given
        run("50");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterBonusNumber);
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("view가 출력되고, 당첨번호를 입력하면 입력값이 return되어야 한다.")
    void inputWinningNumbers() {
        // given
        run("1,2,3,4,5,6");

        // when
        String input = inputConsole.enterWinningNumber();

        // then
        assertEquals("당첨 번호를 입력해 주세요.", output());
        assertEquals("1,2,3,4,5,6", input);
    }

    @Test
    @DisplayName("view가 출력되고, 보너스번호를 입력하면 입력값이 return되어야 한다.")
    void inputBonus() {
        // given
        run("1");

        // when
        String input = inputConsole.enterBonusNumber();

        // then
        assertEquals("보너스 번호를 입력해 주세요.", output());
        assertEquals("1", input);
    }

    @Test
    @DisplayName("당첨번호를 중복 숫자 입력시 IllegalArgumentException과 에러메세지가 출력되어야 한다.")
    void inputWinningNumberDuplicated() {
        // given
        run("1,2,3,4,5,5");

        // expected
        Exception exception = assertThrows(IllegalArgumentException.class, inputConsole::enterWinningNumber);
        assertEquals("[ERROR] 중복 된 숫자가 포함되어있습니다.", exception.getMessage());
    }

    @Override
    protected void runMain() {

    }
}