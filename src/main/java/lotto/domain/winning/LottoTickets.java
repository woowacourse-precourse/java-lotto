package lotto.domain.winning;

import static lotto.domain.constants.LottoConstants.PRICE_OF_LOTTO;
import static lotto.domain.winning.Ranking.ranking;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto_numbers.BonusNumber;
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

    List<Ranking> rankings(Lotto winningNumber, BonusNumber bonusNumber) {
        return winningCandidates(winningNumber)
                .map(winningCandidate -> {
                            int matchCounts = winningNumber.matchCounts(winningCandidate);
                            boolean isMatchedBonus = bonusNumber.isIn(winningCandidate);
                            return ranking(matchCounts, isMatchedBonus);
                        }
                ).collect(Collectors.toList());
    }

    private Stream<Lotto> winningCandidates(Lotto winningNumber) {
        final int MIN_NUMBER_FOR_WINNING = 3;
        return lottoTickets.stream()
                .filter(lotto ->
                        MIN_NUMBER_FOR_WINNING <= lotto.matchCounts(winningNumber));
    }

    public List<Lotto> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}