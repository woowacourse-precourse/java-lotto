package lotto;

import lotto.userinterface.UserInterface;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Integer money = UserInterface.getMoney();

            List<Lotto> randomLottos = LottoMachine.getRandomLottos(money);

            UserInterface.printLottos(randomLottos);

            List<Integer> answerNumbers = UserInterface.getLottoNumbers();

            Integer bonusNumber = UserInterface.getBonusNumber(answerNumbers);

            Lotto answerLotto = Lotto.numberOf(answerNumbers);

            HashMap<Calculator.Hit, Integer> result = Calculator.getLottoResult(randomLottos, answerLotto, bonusNumber);

            Float earningRate = Calculator.getEarningRate(result, money);

            UserInterface.printResult(result);
            UserInterface.printEarningRate(earningRate);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
