package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PurchaseTest {
    @DisplayName("로또 개수를 정상적으로 구하는지 확인한다.")
    @Test
    void getLottoCount_정상동작() {
        int input = Purchase.getLottoCount(5000);
        assertThat(input).isEqualTo(5);
    }
}