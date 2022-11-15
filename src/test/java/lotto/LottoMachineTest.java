package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    @DisplayName("입력한 금액만큼 로또가 발행되는지 테스트")
    @Test
    void publishLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.publishLotto(100000);
        assertThat(lottos.size()).isEqualTo(100);
    }
}
