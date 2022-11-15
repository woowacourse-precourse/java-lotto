package lotto;

import java.util.List;
import lotto.service.Tickets;
import lotto.domain.Winner;
import lotto.ui.Input;
import lotto.ui.Output;
import lotto.service.Calculator;
import lotto.service.Convertor;

public class Application {
    public static void main(String[] args) {
        try {
            Integer purchasePrice = Convertor.toPurchasePrice(Input.payment());
            Tickets lottoTickets = new Tickets(purchasePrice);
            Output.printPurchaseSuccessful(lottoTickets);

            List<Integer> WinningNumbers = Convertor.separate(Input.winningNumbers());
            Integer BonusNumber = Convertor.toNumericValue(Input.bonusNumber());
            Winner winnerTicket = new Winner(WinningNumbers, BonusNumber);

            Calculator calculator = new Calculator(lottoTickets, winnerTicket);
            Output.printStatistics(calculator, purchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
