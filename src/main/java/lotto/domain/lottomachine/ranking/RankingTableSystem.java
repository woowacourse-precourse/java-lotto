package lotto.domain.lottomachine.ranking;

import lotto.domain.lottomachine.lottoticket.LottoTickets;
import lotto.domain.lottomachine.winningnumber.WinningNumber;
import lotto.domain.lottomachine.winningnumber.WinningNumbers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingTableSystem {
    private final WinningNumbers winningNumbers;
    private final WinningNumber bonus;

    private RankingTableSystem(WinningNumbers winningNumbers, WinningNumber bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public static RankingTableSystem of(WinningNumbers numbers, WinningNumber bonus) {
        return new RankingTableSystem(numbers, bonus);
    }

    public RankingTable createRankingTable(LottoTickets tickets) {
        return new RankingTable(countFrequencyByRank(tickets));
    }

    private Map<Ranking, Frequency> countFrequencyByRank(LottoTickets tickets) {
        Map<Ranking, Frequency> frequenciesByRank = new HashMap<>();
        List<String> matchingNumbers = countMatchingNumbersOf(tickets);
        for (Ranking value : Ranking.values()) {
            Frequency frequency = countFrequency(matchingNumbers, getNumberOfMatchingOf(value));
            frequenciesByRank.put(value, frequency);
        }
        return frequenciesByRank;
    }

    private List<String> countMatchingNumbersOf(LottoTickets tickets) {
        return tickets.matchWith(winningNumbers, bonus);
    }

    private Frequency countFrequency(List<String> numbers, String number) {
        return createFrequency(Collections.frequency(numbers, number));
    }

    private Frequency createFrequency(int number) {
        return Frequency.from(number);
    }

    private String getNumberOfMatchingOf(Ranking value) {
        return value.getNumberOfMatching();
    }
}
