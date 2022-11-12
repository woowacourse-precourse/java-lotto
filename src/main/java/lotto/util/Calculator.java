package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Ranks;

public class Calculator {
    public static List<Integer> produceProfit(
            List<List<Integer>> lottoTickets,
            List<Integer> winningNumbers,
            Integer bonusNumber
    ) {
        List<Integer> profit = new ArrayList<>();
        for (List<Integer> lottoTicket : lottoTickets) {
            Matcher matcher = new Matcher(lottoTicket, winningNumbers, bonusNumber);
            Integer prizeMoney = Ranks.getPrizeMoneyBy(matcher);
            profit.add(prizeMoney);
        }
        return profit;
    }
}
