package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Print.getPurchaseAmount();
        int purchaseAmount = Input.getPurchaseAmount();
        List<Lotto> lottos = Operation.buyLotto(purchaseAmount);

        Print.userLottos(purchaseAmount);
        Print.getWinningNumbers();

        List<Integer> winning = Input.getWinningNumbers();
        Print.getBonusNumber();
        int bonus = Input.getBonusNumber();

        Match match= new Match(lottos, winning, bonus);
        Print.result(purchaseAmount,match);

    }
}
