package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInput user = new UserInput();

        Calculator calc = user.inputMoney();

        System.out.printf("%d%s%n%n", calc.quantity, Message.PURCHASE);
        user.generateRandomLotto(calc.quantity);
        user.printLotto();

        Lotto lotto = user.inputWinningNumber();
        int bonus = lotto.inputBonus();

        for (List numbers : user.lotteries) {
            lotto.compareLotto(numbers, bonus);
        }
        calc.printResult();
    }
}
