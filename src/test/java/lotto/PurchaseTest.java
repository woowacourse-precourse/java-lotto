package lotto;

import lotto.domain.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {
    @DisplayName("숫자를 여러 개 입력한 경우 예외가 발생한다.")
    @Test
    void 숫자를_여러_개_입력한_경우() {
        assertThatThrownBy(() -> new Purchase("1200 12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000_단위가_아닌_경우() {
        assertThatThrownBy(() -> new Purchase("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
