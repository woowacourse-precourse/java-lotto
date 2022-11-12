package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        try {
            Print.purchaseMessage();

            List<Lotto> lottery = Purchase.lotto();
            Print.lottery(lottery);

            CheckLotto winningLottery = Winning.getWinningLottery();
            Map<WinningNumber, Integer> matchCount = winningLottery.match(lottery);

            Print.matchResult(matchCount, lottery.size());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
