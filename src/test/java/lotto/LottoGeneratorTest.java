package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    private static final int PRICE_UNIT = 1000;

    @Test
    void 로또_정상_발행_테스트() {
        int price = 2000;
        LottoGenerator lottoGenerator = new LottoGenerator(price);
        List<Lotto> lottos = lottoGenerator.createLottos();
        assertThat(lottos.size()).isEqualTo(price / PRICE_UNIT);
    }
}