package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            List<Lotto> lottery = Purchase.lotto(amountInput());
            Print.lottery(lottery);

            CheckLotto winningLottery = Winning.getWinningLottery(winningNumberInput(), bonusNumberInput());
            Map<WinningNumber, Integer> matchCount = winningLottery.match(lottery);

            Print.matchResult(matchCount, lottery.size());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static String amountInput() {
        Print.purchaseMessage();
        return Console.readLine();
    }

    private static String winningNumberInput() {
        Print.enterWinningNumberMessage();
        return Console.readLine();
    }

    private static String bonusNumberInput() {
        Print.enterBonusNumberMessage();
        return Console.readLine();
    }
}
