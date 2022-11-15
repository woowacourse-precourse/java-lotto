package lotto;

import java.util.List;

public class Controller {
    User user = new User();
    Print print = new Print();
    public void start(){
        int money = user.lotteryPurchaseAmount();
        List<Lotto> lottos = Lottos.publishLottos(money / 1000);
        print.infoLottos(lottos);
        List<Integer> winningNumber = user.winningNumber();
        int bonusNumber = user.bonusNumber();


    }
}
