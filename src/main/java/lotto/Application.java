package lotto;

import lotto.domain.*;

import java.util.List;

public class Application {
    private final Shop shop;
    private Calculator calculator;

    private Application() {
        shop = new Shop();
    }

    private void start() {
        int money = Player.getMoney();
        if (money == 0) {
            return;
        }
        List<Lotto> lottos = shop.buyLottos(money);
        List<Integer> winningNumbers = Player.getWinningNumbers();
        if (winningNumbers == null) {
            return;
        }
        int bonusNumber = Player.getBonusNumber();
        Result result = calculateResult(lottos, winningNumbers, bonusNumber);
        System.out.println(result.toString());
        printReturnRate(money);
    }

    private void printReturnRate(int money) {
        System.out.printf("총 수익률은 %.1f", calculator.returnRate(money));
        System.out.println("%입니다.");
    }

    private Result calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        calculator = new Calculator(winningNumbers, bonusNumber);
        for (Lotto lotto : lottos) {
            calculator.compare(lotto);
        }
        return calculator.getResult();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
