package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserInput user = new UserInput();
        Calculator calc = user.inputMoney();

        Lotto lotto = user.inputWinningNumber();
        int bonus = lotto.inputBonus();

        for (List numbers : calc.lotteries) {
            lotto.compareLotto(numbers, bonus);
        }
        calc.printResult();
    }
}
