package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PurchaseAmountTest {

    @Test
    void 유효성_예외_검증() {
        long missUnitVal = 1001L;
        long overSizeVal = 228713284900000L;

        assertThatThrownBy(() -> new PurchaseAmount(missUnitVal)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PurchaseAmount(overSizeVal)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0, 0","1000, 1", "123000, 123"})
    void 수량_확인(long inputAmount, long expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);

        long actual = purchaseAmount.quantity();

        assertThat(actual).isEqualTo(expected);
    }
}