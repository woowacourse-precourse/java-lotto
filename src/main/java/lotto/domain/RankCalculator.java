package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {
    private final Map<Rank, Integer> ranks;

    public RankCalculator(List<Lotto> lottoTickets, UserNumber userNumber) {
        this.ranks = countRank(lottoTickets, userNumber);
    }

    private Map<Rank, Integer> countRank(List<Lotto> lottoTickets, UserNumber userNumber) {
        Map<Rank, Integer> ranks = initializeRank();

        for (Lotto lottoTicket : lottoTickets) {
            Rank rank = compareLottoWithUser(lottoTicket, userNumber);
            ranks.put(rank, ranks.get(rank) + 1);
        }
        return ranks;
    }

    public Map<Rank, Integer> initializeRank() {
        Map<Rank, Integer> ranks = new HashMap<>();

        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
        return ranks;
    }

    private Rank compareLottoWithUser(Lotto lottoTicket, UserNumber userNumber) {
        List<Integer> lotto = new ArrayList<>(lottoTicket.getNumbers());
        int sameCount = (int) lotto.stream()
                .filter(userNumber.getWinNumbers().getNumbers()::contains)
                .count();

        return Rank.convertRank(sameCount,
                compareBonusNumber(lottoTicket, userNumber.getBonusNumber()));
    }

    private boolean compareBonusNumber(Lotto lottoTicket, int bonusNumber) {
        return lottoTicket.getNumbers().contains(bonusNumber);
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }
}
