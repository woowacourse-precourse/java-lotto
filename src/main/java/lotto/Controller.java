package lotto;

import java.util.List;
import java.util.Map;

public class Controller {
    User user = new User();
    Print print = new Print();
    Winning winning = new Winning();
    Profit profit = new Profit();

    private final int LOTTO_PRICE = 1000;

    public void start(){
        try {
            int money = user.lotteryPurchaseAmount();
            List<Lotto> lottos = Lottos.publishLottos(money / LOTTO_PRICE);
            print.infoLottos(lottos);
            List<Integer> winningNumber = user.winningNumber();
            int bonusNumber = user.bonusNumber();
            Map<Rank, Integer> totalRank = winning.getTotalRank(lottos, winningNumber, bonusNumber);
            print.infoRank(totalRank);
            print.infoProfit(profit.getProfit(totalRank, money));
        }
        catch (IllegalArgumentException e){
            print.infoError(e.getMessage());
        }
    }
}
