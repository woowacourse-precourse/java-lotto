package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.consumer.Profit;
import lotto.machine.Tickets;
import lotto.machine.Winner;

public class Calculator {
    private final List<List<Integer>> lottoTickets;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private final List<Integer> totalProfit;

    public Calculator(Tickets tickets, Winner winner) {
        lottoTickets = tickets.getTickets();
        winningNumbers = winner.getWinningNumbers();
        bonusNumber = winner.getBonusNumber();

        totalProfit = new ArrayList<>();
        updateTotalProfit();
    }

    public List<Integer> getTotalProfit() {
        return totalProfit;
    }

    private void updateTotalProfit() {
        for (List<Integer> lottoTicket : lottoTickets) {
            addPossibleProfit(lottoTicket);
        }
    }

    private void addPossibleProfit(List<Integer> lottoTicket) {
        Matcher matcher = new Matcher(lottoTicket, winningNumbers, bonusNumber);
        Profit profit = new Profit(
                matcher.getMatchingWinningNumberCount(),
                matcher.getMatchingBonusNumberCount()
        );
        totalProfit.add(profit.getProfit());
    }
}
