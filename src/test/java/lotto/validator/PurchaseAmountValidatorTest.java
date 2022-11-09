package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PurchaseAmountValidatorTest {

    @DisplayName("구매 금액 입력 검사")
    @ParameterizedTest
    @ValueSource(strings = {"1001", "-1000", "1234"})
    void purchaseAmountTest(String money) {
        assertThrows(IllegalArgumentException.class, () -> PurchaseAmountValidator.validate(money));
    }

}