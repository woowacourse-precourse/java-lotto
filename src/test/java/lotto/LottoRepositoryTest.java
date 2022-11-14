package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRepositoryTest {

    @Test
    void makeRandomLottosTest() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.makeRandomLottos(5);
        Assertions.assertThat(lottoRepository.lottos.size()).isEqualTo(5);
    }
}