package lotto;

import lotto.UI.Input;
import lotto.UI.Output;
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
        Output.getPurchaseAmount();
        purchaseAmount = Input.getPurchaseAmount();
        lottos = Operation.buyLotto(purchaseAmount);
        Output.userLottos(lottos, purchaseAmount);
    }

    static void calculateResult(){
        Output.getWinningNumbers();
        winning = Input.getWinningNumbers();
        Output.getBonusNumber();
        bonus = Input.getBonusNumber(winning);
    }

    static void printResult(){
        match = new Match(lottos, winning, bonus);
        int earning = Operation.calculateEarning(match);
        double earningRate = Operation.calculateEarningRate(purchaseAmount, earning);
        Output.result(earningRate, match);
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
