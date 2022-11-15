package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행")
    @Test
    void ticketLottoTest() {
        int money = 55000;
        List<Lotto> lottos = new LottoMachine().ticketLottos(money);
        assertThat(lottos.size()).isEqualTo(55);
    }
}
