package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    void 로또구매금액_천원단위_아닐시_예외() {
        int money = 1328;
        assertThatThrownBy(() -> new LottoMachine(money));
    }

    @Test
    void 로또구매금액_유효하지_않을시_예외() {
        int money = -115000;
        assertThatThrownBy(() -> new LottoMachine(money));
    }
}