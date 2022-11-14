package lotto.domain;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void generateLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();

        assertSimpleTest(() -> {
            assertThat(lottoMachine.generateLotto()).isInstanceOf(Lotto.class);
        });
    }
}
