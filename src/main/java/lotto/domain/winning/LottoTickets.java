package lotto.domain.winning;

import static lotto.domain.constants.LottoConstants.PRICE_OF_LOTTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto_numbers.Lotto;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
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

    List<Lotto> winningLottoTickets(Lotto winningNumber) {
        final int MIN_NUMBER_FOR_WINNING = 3;
        return lottoTickets.stream()
                .filter(lotto ->
                        MIN_NUMBER_FOR_WINNING <= lotto.countsOfMatchingNumber(winningNumber))
                .collect(Collectors.toList());
    }
}