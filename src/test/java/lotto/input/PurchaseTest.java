package lotto.input;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseTest {

    @Test
    void validatedAmount_notNumberInput_exceptionThrown() {
        assertThatThrownBy(() -> Purchase.validatedAmount("100a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구입금액은 숫자여야 합니다.");
    }

    @Test
    void validatedAmount_notMultipleOfThousandInput_exceptionThrown() {
        assertThatThrownBy(() -> Purchase.validatedAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1,000원 단위로 구입해야 합니다.");
    }
}