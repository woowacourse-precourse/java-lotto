package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Calculator calc = InputView.inputMoney();

        Lotto lotto = InputView.inputWinningNumber();
        int bonus = lotto.inputBonus();

        for (List numbers : calc.lotteries) {
            lotto.compareLotto(numbers, bonus);
        }
        calc.printResult();
    }
}
