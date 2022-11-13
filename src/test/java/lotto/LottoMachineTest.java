package lotto;

import lotto.domain.Lotto;
import lotto.domain.lottoMachine.LottoMachine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또_생성() {
        List<Lotto> lottos = lottoMachine.createLottoWithMoney(14000);
        Assertions.assertThat(lottos.size()).isEqualTo(14);
    }
}