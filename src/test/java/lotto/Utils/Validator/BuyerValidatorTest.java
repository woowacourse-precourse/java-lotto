package lotto.Utils.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyerValidatorTest {
    @DisplayName("입력받은 구매금액이 문자를 포함하면 예외를 발생한다.")
    @Test
    void createPurchaseAmountByNotInteger() {
        String input = "$2,000";
        assertThatThrownBy(() -> new BuyerValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 구매금액이 자연수가 아니면 예외를 발생한다.")
    @Test
    void createPurchaseAmountByNotNatural() {
        String input = "-2000";
        assertThatThrownBy(() -> new BuyerValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 구매금액이 1000단위가 아니면 예외를 발생한다.")
    @Test
    void createPurchaseAmountByNot1000Unit() {
        String input = "20210";
        assertThatThrownBy(() -> new BuyerValidator(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
