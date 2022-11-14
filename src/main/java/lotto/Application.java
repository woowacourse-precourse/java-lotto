package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Integer ticketsNumber = User.askTicketNumber();
        List<Lotto> lottos = User.buy(ticketsNumber);
        List<Integer> winNumbers = User.askWinNumbers();
        Integer bonusNumber = User.askBonusNumber();

        // Calculator calculator = new Calculator(lotto, bonus);
        // for (Lotto lotto : lottos) {
        //     calculator.doSomething2(lotto);
        // }
        User.getEarning();
    }
}
