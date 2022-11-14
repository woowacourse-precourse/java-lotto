package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosCashierValidUtilsTest {

    @DisplayName("구입 금액은 1000으로 나누어 떨어지지 않으면 예외 발생")
    @Test
    void validateCanPurchase() {
        assertThatThrownBy(() -> LottosCashierValidUtils.validateCanPurchase(12345))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("주어진 금액과 주어진 로또 번호의 개수가 일치하지 않으면 예외 발생")
    @Test
    void validateSize() {
        assertThatThrownBy(() -> LottosCashierValidUtils.validateSize(2, List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(3, 4, 5, 6, 7, 8)
        )))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 주어진 금액과 주어진 로또 번호의 개수가 일치하지 않습니다.");

    }
}
