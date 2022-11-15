package lotto;

import lotto.domain.console.ConsoleIn;
import lotto.domain.console.ConsoleOut;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottocalculator.Calculator;
import lotto.domain.lottomachine.LottoMachine;

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
            HashMap<Hit, Integer> result = Calculator.getLottoResult(randomLottos, answerLotto, bonusNumber);
            Float earningRate = Calculator.getEarningRate(result, money);

            ConsoleOut.printResult(result);
            ConsoleOut.printEarningRate(earningRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
