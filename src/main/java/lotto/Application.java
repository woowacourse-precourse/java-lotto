package lotto;

import java.util.List;
import lotto.consumer.Profit;
import lotto.consumer.Statistics;
import lotto.machine.Tickets;
import lotto.machine.Winner;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.util.Convertor;

public class Application {
    public static void main(String[] args) {
        try {
            String payment = Input.payment();
            Integer purchasePrice = Convertor.toPurchasePrice(payment);

            Tickets tickets = new Tickets(purchasePrice);
            List<List<Integer>> lottoTickets = tickets.getTickets();
            Output.purchaseSuccessful(purchasePrice, lottoTickets);

            List<Integer> winningNumbers = Convertor.separate(Input.winningNumbers());
            Integer bonusNumber = Convertor.toNumericValue(Input.bonusNumber());
            Winner winner = new Winner(winningNumbers, bonusNumber);

            Profit profit = new Profit(
                    lottoTickets,
                    winner.getWinningNumbers(),
                    winner.getBonusNumber()
            );
            Statistics statistics = new Statistics(profit.getProfit());
            Output.lottoResult(purchasePrice, statistics.getStatistics());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
