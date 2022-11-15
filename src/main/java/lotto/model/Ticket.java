package lotto.model;

import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.model.WinningNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {

    private final List<Lotto> ticket;

    public Ticket(List<Lotto> ticket){
        this.ticket=ticket;
    }

    public List<Lotto> getTicket() {
        return ticket;
    }


    public Map<Ranking,Integer> checkRankingCount(WinningNumbers winningNumbers){
        HashMap<Ranking, Integer> results = initializeRanking();
        List<Integer> winningNumber = winningNumbers.getWinningNumbers();
        int bonusNumber = winningNumbers.getBonusNumber();

        for(Lotto lotto: ticket){
            Ranking ranking = lotto.checkResult(winningNumber,bonusNumber);
            rankingCount(results,ranking);
        }
        return results;
    }

    private static void rankingCount(Map <Ranking, Integer> winningResult, Ranking rank) {
        if (rank == Ranking.FAIL) {
            return;
        }
        winningResult.put(rank, winningResult.getOrDefault(rank, 0) + 1);
    }



    private HashMap<Ranking, Integer> initializeRanking() {
        return new HashMap<>(Map.ofEntries(
                Map.entry(Ranking.FIRST, 0),
                Map.entry(Ranking.SECOND, 0),
                Map.entry(Ranking.THIRD, 0),
                Map.entry(Ranking.FOURTH, 0),
                Map.entry(Ranking.FIFTH, 0)
        ));
    }
}
