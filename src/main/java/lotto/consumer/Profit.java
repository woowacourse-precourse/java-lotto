package lotto.consumer;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Tickets;
import lotto.machine.Winner;
import lotto.util.Matcher;
import lotto.machine.Ranks;

public class Profit {
    private final List<Integer> profit;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public Profit(Tickets lottoTickets, Winner winnerTicket) {
        profit = new ArrayList<>();
        winningNumbers = winnerTicket.getWinningNumbers();
        bonusNumber = winnerTicket.getBonusNumber();

        for (List<Integer> lottoTicket : lottoTickets.getTickets()) {
            Matcher matcher = new Matcher(lottoTicket, winningNumbers, bonusNumber);
            Integer prizeMoney = Ranks.getPrizeMoneyBy(matcher);
            profit.add(prizeMoney);
        }
    }

    public List<Integer> getProfit() {
        return profit;
    }
}
