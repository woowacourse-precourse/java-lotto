package lotto.logic;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoLogicTest {

    LottoLogic lottoLogic = new LottoLogic();

    @Test
    void 여섯개의_임의의_중복없는_숫자조합으로_된_로또_생성() {
        for (int i = 0; i < 100; i++) {
            Lotto lotto = lottoLogic.makeLotto();
            Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(6);
        }
    }
}