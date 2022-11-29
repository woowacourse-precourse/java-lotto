package lotto.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static lotto.validation.InputValidation.checkValidation;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @Test
    @DisplayName("enterPurchaseAmount 그룹은 금액을 입력시 exception이 발생하지 않아야한다.")
    void enterPurchaseAmountGroupInput() {
        // given
        String input = "5000";
        String group = "enterPurchaseAmount";

        // expected
        Assertions.assertDoesNotThrow(() -> checkValidation(input, group));
    }

    @Test
    @DisplayName("enterPurchaseAmount 그룹은 null 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterPurchaseAmountGroupInputNull() {
        // given
        String input = "";
        String group = "enterPurchaseAmount";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterPurchaseAmount 그룹은 whiteSpace 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterPurchaseAmountGroupInputWhiteSpace() {
        // given
        String input = " ";
        String group = "enterPurchaseAmount";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterPurchaseAmount 그룹은 숫자가 아닌 것 입력시 NoSuchElementException과 메시지가 출력되어야한다.")
    void enterPurchaseAmountGroupInputNotNumber() {
        // given
        String input = "천원";
        String group = "enterPurchaseAmount";

        // expected
        Exception exception = assertThrows(
                NoSuchElementException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 숫자를 입력 하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("enterPurchaseAmount 그룹은 1000단위로 입력하지 않을시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterPurchaseAmountGroupInputNot1000Units() {
        // given
        String input = "1234";
        String group = "enterPurchaseAmount";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 1,000원 단위로 입력 하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("enterPurchaseAmount 그룹은 21억 초과로 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterPurchaseAmountGroupInputOver2Point1Billion() {
        // given
        String input = "2100001000";
        String group = "enterPurchaseAmount";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 21억 이하로 입력하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("enterWinningNumber 그룹은 숫자와 쉼표입력시 exception이 발생하지 않아야한다.")
    void enterWinningNumberGroupInput() {
        // given
        String input = "1,2,3,4,5,6";
        String group = "enterWinningNumber";

        // expected
        assertDoesNotThrow(() -> checkValidation(input, group));
    }

    @Test
    @DisplayName("enterWinningNumber 그룹은 null 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterWinningNumberGroupInputNull() {
        // given
        String input = "";
        String group = "enterWinningNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterWinningNumber 그룹은 whiteSpace 입력 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterWinningNumberGroupInputWhiteSpace() {
        // given
        String input = "    ";
        String group = "enterWinningNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterWinningNumber 그룹은 숫자나 쉼표 이외의 값 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterWinningNumberGroupInputNotNumberOrComma() {
        // given
        String input = "1,2,3,사,five,6";
        String group = "enterWinningNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 숫자나 쉼표만 입력 해야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterWinningNumber 그룹은 숫자 6개가 아닌 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterWinningNumberGroupInputNotSixNumbers() {
        // given
        String input = "1,2,3,4,5,6,7";
        String group = "enterWinningNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 6개의 숫자를 입력해 주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("enterWinningNumber 그룹은 숫자 1~45값이 아닌값 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterWinningNumberGroupInputNot1To45() {
        // given
        String input = "1,2,3,4,5,46";
        String group = "enterWinningNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterWinningNumber 그룹은 중복 숫자 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterWinningNumberGroupInputDuplicatedNumber() {
        // given
        String input = "1,2,3,4,5,5";
        String group = "enterWinningNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 중복 된 숫자가 포함되어있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterBonusNumber 숫자와 입력시 exception이 발생하지 않아야한다.")
    void enterBonusNumberGroupInput() {
        // given
        String input = "1";
        String group = "enterBonusNumber";

        // expected
        assertDoesNotThrow(() -> checkValidation(input, group));
    }

    @Test
    @DisplayName("enterBonusNumber 그룹은 null 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterBonusNumberGroupInputNull() {
        // given
        String input = "";
        String group = "enterBonusNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterBonusNumber 그룹은 whiteSpace 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterBonusNumberGroupInputWhiteSpace() {
        // given
        String input = "    ";
        String group = "enterBonusNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 아무것도 입력하지 않았습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("enterBonusNumber 그룹은 숫자 이외의 입력시 NoSuchElementException 메시지가 출력되어야한다.")
    void enterBonusNumberGroupInputNotNumber() {
        // given
        String input = "사십";
        String group = "enterBonusNumber";

        // expected
        Exception exception = assertThrows(
                NoSuchElementException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 숫자를 입력 하세요.", exception.getMessage());
    }

    @Test
    @DisplayName("enterBonusNumber 그룹은 숫자 1~45 이외의 입력시 IllegalArgumentException과 메시지가 출력되어야한다.")
    void enterBonusNumberGroupInputNot1To45() {
        // given
        String input = "46";
        String group = "enterBonusNumber";

        // expected
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> checkValidation(input, group)
        );
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }
}