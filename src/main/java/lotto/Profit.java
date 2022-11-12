package lotto;

import java.util.ArrayList;
import java.util.List;

public class Profit {
    public static void calculateProfit(int price) {
        List<Integer> winningResult = Winning.winningResult;
        List<Integer> prizeMoney = new ArrayList<>(List.of(5000, 50000, 1500000, 30000000, 2000000000));
        int totalProfit = 0;
        for (int index = 0; index < 5 ; index++) {
            totalProfit += winningResult.get(index) * prizeMoney.get(index);
        }
        double profitRate = (double)totalProfit / price * 100;
        System.out.println(GameMessage.PROFIT_HEAD_MESSAGE.getMessage() + Double.toString(profitRate) + GameMessage.PROFIT_TAIL_MESSAGE.getMessage());
    }
}
