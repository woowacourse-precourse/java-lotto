package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 로또_발행_테스트() {
        int lottoCount = 2;

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.createLottos(lottoCount);

        assertThat(lottos.size()).isEqualTo(lottoCount);
    }
}