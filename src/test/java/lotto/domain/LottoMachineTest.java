package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 생성한_로또번호_검증_테스트() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> lottoMachine.generateLotto());
    }
}