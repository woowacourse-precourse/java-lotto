package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseAmountTest {

    @Test
    @DisplayName("1000 단위가 아닌 값은 에러가 발생한다.")
    void checkInTheThousands1() {
        // given
        String purchaseAmount = "15200";

        // when, then
        assertThrows(IllegalArgumentException.class, () -> PurchaseAmount.checkException(purchaseAmount));
    }

    @Test
    @DisplayName("1000 단위의 값은 에러가 발생하지 않는다.")
    void checkInTheThousands2() {
        // given
        String purchaseAmount = "35000";

        // when, then
        assertDoesNotThrow(() -> PurchaseAmount.checkException(purchaseAmount));
    }
}
