package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInput user = new UserInput();

        Calculator calc = user.inputMoney();

        user.generateRandomLotto(calc.quantity);

        Lotto lotto = user.inputWinningNumber();
        int bonus = lotto.inputBonus();

        for (List numbers : user.lotteries) {
            lotto.compareLotto(numbers, bonus);
        }
        calc.printResult();
    }
}
