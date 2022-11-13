package lotto;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = Input.getPurchaseAmount();
        List<Lotto> lottos = Operation.buyLotto(amount);
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
        List<Integer> winning = Input.getWinningNumbers();
        int bonus = Input.getBonusNumber();
        HashMap<Integer, Integer> result = Operation.calculateMatches(lottos, winning, bonus);
        System.out.println(result);
    }
}
