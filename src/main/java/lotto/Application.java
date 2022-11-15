package lotto;

import lotto.UI.Input;
import lotto.UI.Print;
import lotto.domain.Match;
import lotto.domain.Operation;

import java.util.List;

public class Application {
    static int purchaseAmount;
    static List<Lotto> lottos;
    static List<Integer> winning;
    static int bonus;
    static Match match;

    static void buy() {
        Print.getPurchaseAmount();
        purchaseAmount = Input.getPurchaseAmount();
        lottos = Operation.buyLotto(purchaseAmount);
        Print.userLottos(lottos, purchaseAmount);
    }

    static void calculateResult(){
        Print.getWinningNumbers();
        winning = Input.getWinningNumbers();
        Print.getBonusNumber();
        bonus = Input.getBonusNumber(winning);
    }

    static void printResult(){
        match = new Match(lottos, winning, bonus);
        int earning = Operation.calculateEarning(match);
        double earningRate = Operation.calculateEarningRate(purchaseAmount, earning);
        Print.result(earningRate, match);
    }

    static void playGame() {
        try {
            buy();
            calculateResult();
            printResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
