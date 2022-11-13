package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Integer ticketsNumber = User.askTicketNumber();
        List<Lotto> lottos = User.buy(ticketsNumber);
        List<Integer> numbers = User.askWinNumbers();
        Lotto winNumbers = new Lotto(numbers); // 프린트되나?
        Integer bonus = User.askBonusNumbers();

        // Calculator calculator = new Calculator(lotto, bonus);
        // for (Lotto lotto : lottos) {
        //     calculator.doSomething2(lotto);
        // }
        User.getEarning();
    }
}
