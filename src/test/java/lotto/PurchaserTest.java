package lotto;

import lotto.domain.Purchaser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaserTest {

    @DisplayName("구입금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createPurchaserByNotNumber() {
        assertThatThrownBy(() -> new Purchaser("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원보다 작으면 예외가 발생한다.")
    @Test
    void 구매자_구입금액이_1000원_미만() {
        assertThatThrownBy(() -> new Purchaser("800"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원으로 안 나누어 떨어지면 예외가 발생한다.")
    @Test
    void 구매자_구입금액이_1000_배수가_아님() {
        assertThatThrownBy(() -> new Purchaser("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}