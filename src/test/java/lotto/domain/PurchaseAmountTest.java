package lotto.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @Test
    void 숫자_외_입력_예외_처리() {
        assertThatThrownBy(() -> new PurchasedAmount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천원_미만_입력_예외_처리() {
        assertThatThrownBy(() -> new PurchasedAmount("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천원_단위_아닐_시_입력_예외_처리() {
        assertThatThrownBy(() -> new PurchasedAmount("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
