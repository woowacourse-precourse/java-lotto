package lotto.domain.winning;

import static lotto.domain.policy.LottoPolicy.PRICE_OF_LOTTO;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto_numbers.Lotto;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoResults lotteryResults(WinningLotto winningLotto) {
        return winningLotto.lotteryResults(lottoTickets);
    }

    int totalPayment() {
        return PRICE_OF_LOTTO * totalCounts();
    }

    public int totalCounts() {
        return lottoTickets.size();
    }

    public List<Lotto> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}