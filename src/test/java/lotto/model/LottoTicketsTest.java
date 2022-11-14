package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void getLotteryList_SetInCorrectSize() {
        Purchase purchase = new Purchase(5000);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        List<Lotto> lotteryNumbers = lottoTickets.getLottoTickets();
        assertThat(lotteryNumbers.size()).isEqualTo(5);
    }

    @Test
    void getLotteryList_SetInElementOfLotto() {
        Purchase purchase = new Purchase(4000);
        LottoTickets lottoTickets = new LottoTickets(purchase);
        List<Lotto> lotteryNumbers = lottoTickets.getLottoTickets();
        for (Lotto lotto : lotteryNumbers) {
            assertThat(lotto).isInstanceOf(Lotto.class);
        }
    }
}