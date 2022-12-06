package lotto;

import lotto.domain.InputValidator;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings={"s","-5","1300"})
    void createWrongPurchaseAmountInput(String input) {
        assertThatThrownBy(() ->
                PurchaseAmount.validate(InputValidator.validate(input)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
