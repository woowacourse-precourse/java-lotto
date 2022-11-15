package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @Test
    @DisplayName("로또 구입금을 알면 구매할 로또 개수를 알 수 있다. ")
    void 구매_로또_개수_구하기() {
        LottoStore lottoStore = new LottoStore();
        int lottoAmount = lottoStore.getLottoAmount(10000);
        assertThat(lottoAmount).isEqualTo(10);
    }

}