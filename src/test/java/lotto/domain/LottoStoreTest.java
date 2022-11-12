package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {
    @DisplayName("5000원으로 로또 5개 발급")
    @Test
    void sell5Lottos() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sellLotto(5000);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("0원으로 로또 0개 발급")
    @Test
    void sell0Lotto() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.sellLotto(0);
        assertThat(lottos.size()).isEqualTo(0);
    }

    @DisplayName("판매하는 로또 번호는 6개")
    @Test
    void numbersIn1Lotto() {
        for (int i = 0; i < 10; i++) {
            LottoStore lottoStore = new LottoStore();
            List<Lotto> lottos = lottoStore.sellLotto(10000);
            int theNumberOfValidLottos = (int) lottos.stream().filter(lotto -> {
                for (Integer n : lotto.getNumbers()) {
                    if (n < 1 || n > 45) {
                        return false;
                    }
                }
                return true;
            }).count();
            assertThat(theNumberOfValidLottos).isEqualTo(10);
        }
    }
}