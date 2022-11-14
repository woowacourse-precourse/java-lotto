package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 로또_발행_테스트() {
        final int LOTTO_COUNT = 2;
        final int LOTTO_LENGTH = 6;

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.createLottos(LOTTO_COUNT);

        assertThat(lottos.size()).isEqualTo(LOTTO_COUNT);
        assertThat(lottos.get(0).getLottoNumbers().stream().distinct().count())
                .isEqualTo(LOTTO_LENGTH);
    }
}