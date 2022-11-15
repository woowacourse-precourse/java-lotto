package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void makeRandomLottosTest() {
        LottoService lottoService = new LottoService();
        lottoService.makeRandomLottos(5);
        Assertions.assertThat(lottoService.lottos.size()).isEqualTo(5);
    }
}