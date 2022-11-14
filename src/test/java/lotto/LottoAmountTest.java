package lotto;

import lotto.domain.LottoAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAmountTest {

    @DisplayName("로또 구입 금액이 1000원 미만일시 예외가 발생한다.")
    @Test
    void createLottoAmountByUnderSize() {
        assertThatThrownBy(() -> new LottoAmount(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닐 시 예외가 발생한다.")
    @Test
    void createLottoByNotThousandUnitNumber() {
        assertThatThrownBy(() -> new LottoAmount(12300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 100,000원을 초과할 시 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new LottoAmount(1000000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
