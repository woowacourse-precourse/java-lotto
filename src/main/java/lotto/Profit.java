package lotto;

import java.util.ArrayList;
import java.util.List;

public class Profit {
    private final List<Integer> profit;

    public Profit(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, Integer bonusNumber) {
        profit = new ArrayList<>();

        for (List<Integer> lottoTicket : lottoTickets) {
            Matcher matcher = new Matcher(
                    lottoTicket,
                    winningNumbers,
                    bonusNumber
            );
            Integer prizeMoney = Ranks.getPrizeMoneyBy(
                    matcher.getMatchingWinningNumberCount(),
                    matcher.getMatchingBonusNumberCount()
            );
            profit.add(prizeMoney);
        }
    }

    public List<Integer> getProfit() {
        return profit;
    }
}
