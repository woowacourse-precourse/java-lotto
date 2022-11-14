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
            Integer purchasePrice = Convertor.toPurchasePrice(Input.payment());
            Tickets lottoTickets = new Tickets(purchasePrice);
            Output.purchaseSuccessful(purchasePrice, lottoTickets.getTickets());

            List<Integer> WinningNumbers = Convertor.separate(Input.winningNumbers());
            Integer BonusNumber = Convertor.toNumericValue(Input.bonusNumber());
            Winner winnerTicket = new Winner(WinningNumbers, BonusNumber);

//            Profit profit = new Profit(lottoTickets, winnerTicket);
//            Statistics statistics = new Statistics(profit);
//            Output.lottoResult(purchasePrice, statistics.getStatistics());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
