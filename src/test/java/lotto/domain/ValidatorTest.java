package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @DisplayName("로또 구매 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputAmountWithNonNumeric() {
        String input = "a";
        assertThatThrownBy(() -> validator.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
