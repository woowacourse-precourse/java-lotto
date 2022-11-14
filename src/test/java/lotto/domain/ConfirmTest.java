package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConfirmTest {
    @DisplayName("구입 금액에 숫자가 아닌 것이 들어가면 예외가 발생한다.")
    @Test
    void inputDigitByNotDigit() {
        assertThatThrownBy(() -> Confirm.validateDigit("1234j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}