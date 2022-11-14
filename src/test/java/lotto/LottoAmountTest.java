package lotto;

import lotto.logic.LottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {
    @DisplayName("구매 금액은 1000원 단위로 나누어 떨어져야 한다.")
    @Test
    void createLottoAmountByOverUnit() {
        assertThatThrownBy(() -> LottoAmount.getLottoAmount(2200L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 갯수는 1000원 당 1개이다")
    @Test
    void createLottoAmount() {
        assertThat(LottoAmount.getLottoAmount(2000L)).isEqualTo(2L);
    }
}
