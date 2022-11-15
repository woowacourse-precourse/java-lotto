package lotto;

import lotto.userinterface.ConsoleIn;
import lotto.userinterface.ConsoleOut;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Integer money = ConsoleIn.getMoney();

            List<Lotto> randomLottos = LottoMachine.getRandomLottos(money);

            ConsoleOut.printLottos(randomLottos);

            List<Integer> answerNumbers = ConsoleIn.getLottoNumbers();

            Integer bonusNumber = ConsoleIn.getBonusNumber(answerNumbers);

            Lotto answerLotto = Lotto.numberOf(answerNumbers);

            HashMap<Calculator.Hit, Integer> result = Calculator.getLottoResult(randomLottos, answerLotto, bonusNumber);

            Float earningRate = Calculator.getEarningRate(result, money);

            ConsoleOut.printResult(result);
            ConsoleOut.printEarningRate(earningRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
