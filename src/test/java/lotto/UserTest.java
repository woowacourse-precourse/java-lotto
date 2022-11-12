package lotto;

import lotto.input.MockInputReader;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    @ParameterizedTest(name = "{0}를 구매 금액으로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"abcd", "-1000", "1000!@", "(1000)"})
    void validatePurchaseAmountNotNumberInput(String purchaseAmountInput) {
        User user = new User(new MockInputReader(purchaseAmountInput));
        assertThatThrownBy(() -> user.askPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_AMOUNT_NOT_NUMBER_INPUT_ERROR);
    }

    @ParameterizedTest(name = "{0}를 구매 금액으로 입력시 예외가 발생한다.")
    @ValueSource(strings = {"1", "1001", "100", "999"})
    void validatePurchaseAmountNotDividedBy1000Input(String purchaseAmountInput) {
        User user = new User(new MockInputReader(purchaseAmountInput));
        assertThatThrownBy(() -> user.askPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_AMOUNT_NOT_DIVIDED_BY_1000_ERROR);
    }
}
