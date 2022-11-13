package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Calculator calculator = new Calculator();

        Integer tickets = user.askTickets();

        // Lotto(numbers, tickets)

        List<Integer> numbers = user.askWinNumbers();
        Lotto lotto = new Lotto(numbers);
        Integer bonus = user.askBonusNumbers();

        // calculator.doSomething(lotto, bonus);
        user.getEarning();
    }
}
