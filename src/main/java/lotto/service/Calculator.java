package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Profit;
import lotto.domain.Matcher;
import lotto.domain.Winner;

public class Calculator {
    private final List<List<Integer>> lottoTickets;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private final List<Integer> totalProfit;

    public Calculator(Tickets lottoTickets, Winner winnerTicket) {
        this.lottoTickets = lottoTickets.getTickets();
        this.winningNumbers = winnerTicket.getWinningNumbers();
        this.bonusNumber = winnerTicket.getBonusNumber();

        this.totalProfit = new ArrayList<>();
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
        final Matcher matcher = new Matcher(lottoTicket, winningNumbers, bonusNumber);
        final Profit profit = new Profit(
                matcher.getMatchingWinningNumberCount(),
                matcher.getMatchingBonusNumberCount()
        );
        totalProfit.add(profit.getProfit());
    }
}
