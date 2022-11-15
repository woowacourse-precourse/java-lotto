package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoStoreTest {

    @Test
    @DisplayName("로또 구입금을 알면 구매할 로또 개수를 알 수 있다. ")
    void 구매_로또_개수_구하기() {
        LottoStore lottoStore = new LottoStore();
        int lottoAmount = lottoStore.getLottoAmount(10000);
        assertThat(lottoAmount).isEqualTo(10);
    }

    @DisplayName("로또 구매 개수만큼 로또를 발행할 수 있다.")
    @Test
    void 로또를_구매해_발행받기() {
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottoTickets = lottoStore.buyLottoTickets(10000);
        assertThat(lottoTickets.size()).isEqualTo(10);
    }
}