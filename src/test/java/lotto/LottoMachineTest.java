package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또_생성() {
        List<Lotto> lottos = lottoMachine.createLottoWithMoney(14000);
        Assertions.assertThat(lottos.size()).isEqualTo(14);
    }
}