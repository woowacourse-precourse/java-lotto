package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("투입한 금액에 알맞는 갯수의 로또가 발행되는지 확인")
    @Test
    void lotteriesByPurchaseAmount() {
        LottoMachine machine = new LottoMachine(10_000);
        List<Lotto> lotteries = machine.lottoForAmount();

        assertThat(lotteries.size()).isEqualTo(10);
    }
}