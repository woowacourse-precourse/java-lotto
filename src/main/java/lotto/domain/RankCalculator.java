package lotto.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {

    private Map<Rank, Integer> ranks;

    public RankCalculator(List<Lotto> lottoTickets, UserNumber userNumber) {
        this.ranks = countRank(lottoTickets, userNumber);
    }

    private Map<Rank, Integer> countRank(List<Lotto> lottoTickets, UserNumber userNumber) {
        Map<Rank, Integer> ranks = new HashMap<>();

        for (Lotto lottoTicket : lottoTickets) {
            Rank rank = compareLottoWithUser(lottoTicket, userNumber);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return ranks;
    }

    private Rank compareLottoWithUser(Lotto lottoTicket, UserNumber userNumber) {
        List<Integer> list = new ArrayList<>(lottoTicket.getNumbers());
        int correct = 0;

        for (int number : userNumber.getWinNumbers().getNumbers()) {
            if (list.contains(number)) {
                correct++;
            }
        }
        return convertRank(correct, compareBonusNumber(lottoTicket, userNumber.getBonusNumber()));
    }

    private Rank convertRank(int count, boolean isSecond) {
        for (Rank rank : Rank.values()) {
            if (count == Rank.SECOND.getCorrectCount() && isSecond) {
                return Rank.SECOND;
            } else if (count == rank.getCorrectCount()) {
                return rank;
            }
        }
        return Rank.NONE;
    }

    private boolean compareBonusNumber(Lotto lottoTicket, int bonusNumber) {
        return lottoTicket.getNumbers().contains(bonusNumber);
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }
}
