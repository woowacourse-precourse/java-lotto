package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void generateLottoTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNumbers = lottoMachine.generateLottoNumbers();
        Lotto generatedLotto = lottoMachine.generateLotto(lottoNumbers);

        assertSimpleTest(() -> {
            assertThat(generatedLotto.getNumbers()).isEqualTo(lottoNumbers);
        });
    }

}
