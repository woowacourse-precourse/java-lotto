package lotto;

import java.util.List;
import java.util.Map;

public class Controller {
    User user = new User();
    Print print = new Print();
    Winning winning = new Winning();
    public void start(){
        int money = user.lotteryPurchaseAmount();
        List<Lotto> lottos = Lottos.publishLottos(money / 1000);
        print.infoLottos(lottos);
        List<Integer> winningNumber = user.winningNumber();
        int bonusNumber = user.bonusNumber();
        Map<Rank, Integer> totalRank = winning.getTotalRank(lottos, winningNumber, bonusNumber);
        print.infoRank(totalRank);
    }
}
