package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("로또 구매 수량을 구한다")
    @Test
    void countPurchasedLotto(){
        assertThat(LottoMachine.countPurchasedLotto(14000))
                .isEqualTo(14);
    }
}
