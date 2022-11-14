package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
