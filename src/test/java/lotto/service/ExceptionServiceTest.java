package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("예외 처리 테스트")
class ExceptionServiceTest {

    @Test
    @DisplayName("입력받은 금액이 숫자가 아니면 예외가 발생한다.")
    void exceptionHandlingOfPurchaseAmountTest() {
        ExceptionService exceptionService = new ExceptionService();
        String amount = "팔천원";
        assertThatThrownBy(() -> exceptionService.exceptionHandlingOfPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void checkIfAmountIsDivisibleByOneThousandTest() {
        ExceptionService exceptionService = new ExceptionService();
        String amount = "8500";
        assertThatThrownBy(() -> exceptionService.exceptionHandlingOfPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 금액이 음수면 예외가 발생한다.")
    void checkIfAmountIsPositiveTest() {
        ExceptionService exceptionService = new ExceptionService();
        String amount = "-8000";
        assertThatThrownBy(() -> exceptionService.exceptionHandlingOfPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 항복이 6개가 아니면 예외가 발생한다.")
    void checkIfTheWinningNumbersHasSixCharactersBasedOnTheConmaTest() {
        ExceptionService exceptionService = new ExceptionService();
        String winningNumbers = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> exceptionService.exceptionHandlingOfWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 공백이 들어가면 예외가 발생한다.")
    void checkForSpacesInWinningNumbersTest() {
        ExceptionService exceptionService = new ExceptionService();
        String winningNumbers = "1 ,2 ,3,4,5,6";
        assertThatThrownBy(() -> exceptionService.exceptionHandlingOfWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 중복이 있을시 예외가 발생한다.")
    void checkForDupliCateWinningNumbersTest() {
        ExceptionService exceptionService = new ExceptionService();
        String winningNumbers = "1,2,2,4,5,6";
        assertThatThrownBy(() -> exceptionService.exceptionHandlingOfWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}