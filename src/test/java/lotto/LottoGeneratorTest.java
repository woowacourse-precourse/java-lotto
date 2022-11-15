package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 로또_발행_테스트() {
        int lottoCount = 2;
        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        List<Lotto> lottos = lottoGenerator.createLottos();

        assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}