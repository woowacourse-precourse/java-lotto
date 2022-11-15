package lotto;

import lotto.UI.Print;
import lotto.UI.User;
import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Print print = new Print();
        Winning winning = new Winning();
        Profit profit = new Profit();

        final int LOTTO_PRICE = 1000;
        try {
            int money = user.lotteryPurchaseAmount();
            List<Lotto> lottos = Lottos.publishLottos(money / LOTTO_PRICE);
            print.infoLottos(lottos);
            List<Integer> winningNumber = user.winningNumber();
            int bonusNumber = user.bonusNumber(winningNumber);
            Map<Rank, Integer> totalRank = winning.getTotalRank(lottos, winningNumber, bonusNumber);
            print.infoRank(totalRank);
            print.infoProfit(profit.getProfit(totalRank, money));
        }
        catch (IllegalArgumentException e){
            print.infoError(e.getMessage());
        }
    }
}
