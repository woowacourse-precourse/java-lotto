package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseAmountTest {

    @Test
    void 유효성_예외_검증() {
        int missUnitVal = 1001;
        int overSizeVal = -1000;

        assertThatThrownBy(() -> new PurchaseAmount(missUnitVal)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(overSizeVal)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1000, 1", "123000, 123"})
    void 수량_확인(int inputAmount, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);

        int actual = purchaseAmount.quantity();

        assertThat(actual).isEqualTo(expected);
    }
}