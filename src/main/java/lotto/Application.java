package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Calculator calc = InputView.inputMoney();

        Lotto lotto = InputView.inputWinningNumber();
        int bonus = lotto.inputBonus();

        for (List randomLotto : calc.lotteries) {
            lotto.compareLotto(randomLotto, bonus);
        }
        calc.printResult();
    }
}
