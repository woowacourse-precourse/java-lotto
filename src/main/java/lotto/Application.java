package lotto;


import java.util.List;

public class Application {
    static int purchaseAmount;
    static List<Lotto> lottos;
    static int bonus;
    static List<Integer> winning;
    static Match match;
    static int earning;
    static double earningRate;

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
        earning = Operation.calculateEarning(match);
        earningRate = Operation.calculateEarningRate(purchaseAmount, earning);
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
