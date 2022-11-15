package lotto;

import java.util.List;

import static lotto.Message.*;

public class Game {
    User user = new User();

    public void buyLotto() {
        System.out.println(INPUT_MONEY.getMessage());
        int money = user.inputMoney();
        List<List<Integer>> winLottos = Lotto.makeLotto(Lotto.count(money));
        System.out.println(Lotto.count(money) + COUNT_LOTTO.getMessage());
        for (List<Integer> winLotto : winLottos) {
            System.out.println(winLotto);
        }
    }
}