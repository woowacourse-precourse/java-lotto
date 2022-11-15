package lotto;

import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR;
import static lotto.ErrorMessage.PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR;
import static lotto.ErrorMessage.WINNING_NUMBER_NOT_NUMBER_INPUT_ERROR;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_RANGE_ERROR;
import static lotto.ErrorMessage.INVALID_LOTTO_NUMBER_SIZE_ERROR;
import static lotto.ErrorMessage.BONUS_NUMBER_NOT_NUMBER_INPUT_ERROR;
import static lotto.ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR;
import static lotto.ErrorMessage.BONUS_NUMBER_EXIST_IN_WINNING_NUMBER_ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.input.MockInputReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

public class UserTest {
    @ParameterizedTest(name = "숫자가 아닌 {0}를 구매 금액으로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"abcd", "-1000", "1000!@", "(1000)"})
    void validateInputPurchaseAmountNotNumber(String purchaseAmountInput) {
        User user = new User(new MockInputReader(purchaseAmountInput));

        assertThatThrownBy(() -> user.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR);
    }

    @ParameterizedTest(name = "1000으로 나누어 떨어지지 않는 {0}를 구매 금액으로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"1", "1001", "100", "999"})
    void validateInputPurchaseAmountNotDividedBy1000(String purchaseAmountInput) {
        User user = new User(new MockInputReader(purchaseAmountInput));

        assertThatThrownBy(() -> user.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR);
    }

    @ParameterizedTest(name = "숫자가 아닌 {0}을 당첨 번호로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"a,b,c,d,e,f", "(1,2,3,4,5,6)", "3, 4, 5, 6, 7, 8", "1,2,3,4,5, "})
    void validateInputWinningNumberNotNumber(String winningNumberInput) {
        User user = new User(new MockInputReader(winningNumberInput));

        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WINNING_NUMBER_NOT_NUMBER_INPUT_ERROR);
    }

    @ParameterizedTest(name = "로또 번호 범위를 벗어난 {0}을 당첨 번호로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"0,1,2,3,4,5", "41,42,43,44,45,46"})
    void validateInputWinningNumberInvalidRange(String winningNumberInput) {
        User user = new User(new MockInputReader(winningNumberInput));

        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }

    @DisplayName("당첨 번호를 6개로 입력하지 않는 경우 예외가 발생한다.")
    @Test
    void validateInputWinningNumberInvalidSize() {
        User user = new User(new MockInputReader("1,2,3,4,5"));

        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_SIZE_ERROR);
    }

    @DisplayName("당첨 번호에 중복이 존재하는 경우 예외가 발생한다.")
    @Test
    void validateInputDuplicatedWinningNumber() {
        User user = new User(new MockInputReader("1,2,3,4,5,5"));

        assertThatThrownBy(() -> user.inputWinningNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DUPLICATE_ERROR);
    }

    @ParameterizedTest(name = "숫자가 아닌 {0}을 보너스 번호로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"a", "?", " "})
    void validateInputBonusNumberNotNumber(String bonusNumberInput) {
        User user = new User(new MockInputReader(bonusNumberInput));

        assertThatThrownBy(() -> user.inputBonusNumber(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_NOT_NUMBER_INPUT_ERROR);
    }

    @ParameterizedTest(name = "로또 번호 범위를 벗어난 {0}을 보너스 번호로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"0", "46"})
    void validateInputBonusNumberInvalidRange(String bonusNumberInput) {
        User user = new User(new MockInputReader(bonusNumberInput));

        assertThatThrownBy(() -> user.inputBonusNumber(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }

    @DisplayName("당첨 번호에 이미 존재하는 숫자를 보너스 번호로 입력할때 예외가 발생한다.")
    @Test
    void validateInputBonusNumberExistInWinningNumber() {
        User user = new User(new MockInputReader("1"));

        assertThatThrownBy(() -> user.inputBonusNumber(List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_EXIST_IN_WINNING_NUMBER_ERROR);
    }
}