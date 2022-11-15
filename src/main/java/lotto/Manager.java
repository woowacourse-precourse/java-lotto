package lotto;

import java.util.List;
import java.util.Map;

public class Manager {

    User user = new User();

    Map<Rank,Integer> winningBoard;

    public void inputMoney() {
        UserInput input = new UserInput();
        int money = input.moneyInput();
        user.setMoney(money);
    }

    public void compareLotto() {
        Compare compare = new Compare();

        for (Lotto lotto : user.getLottos()) {
            compare.compareLotto(lotto);
        }
    }
}
