package lotto.consumer;

import java.util.ArrayList;
import java.util.List;
import lotto.machine.Tickets;
import lotto.machine.Winner;
import lotto.util.Calculator;
import lotto.util.Matcher;
import lotto.machine.Ranks;

public class Profit {
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private final List<Integer> profit;

    public Profit(Tickets lottoTickets, Winner winnerTicket) {
        winningNumbers = winnerTicket.getWinningNumbers();
        bonusNumber = winnerTicket.getBonusNumber();

        profit = Calculator.produceProfit(
                lottoTickets.getTickets(),
                winningNumbers,
                bonusNumber
        );
    }

    public List<Integer> getProfit() {
        return profit;
    }
}
