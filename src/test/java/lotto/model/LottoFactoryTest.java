package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {
    @Test
    void 사용자_로또를_1개_생성하는_기능() {
        LottoFactory lottoFactory = new LottoFactory();
        Lottos lottos = lottoFactory.generate(1);
        assertThat(lottos.getSize()).isEqualTo(1);
    }
}