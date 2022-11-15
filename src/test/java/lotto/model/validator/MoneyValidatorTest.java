package lotto.model.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.vallidator.MoneyValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyValidatorTest {
    @DisplayName("숫자가 양수가 아니면 예외가 발생한다.")
    @Test
    void numberNotPositive() {
        assertThatThrownBy(() -> MoneyValidator.validate(-1000))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> MoneyValidator.validate(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1000의 배수가 아니면 예외가 발생한다.")
    @Test
    void numberNotMultiple1000() {
        assertThatThrownBy(() -> MoneyValidator.validate(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1000의 배수인 양수인 경우 예외가 발생하지 않는다.")
    @Test
    void numberAppropriate() {
        assertThatNoException().isThrownBy(() -> MoneyValidator.validate(1000));
    }
}
