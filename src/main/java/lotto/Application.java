package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Integer ticketNumber = User.askTicketNumber();
            List<Lotto> lottos = User.buy(ticketNumber);

            List<Integer> winNumbers = User.askWinNumbers();
            Integer bonusNumber = User.askBonusNumber();
            new Lotto(winNumbers, bonusNumber);

            Calculator calculator = new Calculator(ticketNumber);
            calculator.calculate(lottos);
            calculator.printStatistic();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
