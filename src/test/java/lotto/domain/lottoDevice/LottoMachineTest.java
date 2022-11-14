package lotto.domain.lottoDevice;

import lotto.domain.lottoData.Lotto;
import lotto.domain.lottoDevice.LottoMachine;
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