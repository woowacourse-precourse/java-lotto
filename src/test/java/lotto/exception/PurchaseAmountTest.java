package lotto.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PurchaseAmountTest {
    private final String notInTheThousandsMessage = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

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

    @Test
    @DisplayName("1000 단위가 아닌 값을 입력받아 에러가 발생하면 [ERROR]로 시작하는 메세지를 반환한다.")
    void errorMessageTest() {
        // given
        String purchaseAmount = "12222";

        try {
            // when
            PurchaseAmount.checkException(purchaseAmount);
        } catch (IllegalArgumentException e) {
            // then
            assertThat(e.getMessage()).isEqualTo(notInTheThousandsMessage);
        }
    }

    @Test
    @DisplayName("숫자가 아닌 값은 에러가 발생한다.")
    void checkInteger() {
        String purchaseAmount = "1000-";

        assertThrows(IllegalArgumentException.class, () -> PurchaseAmount.checkException(purchaseAmount));
    }
}
