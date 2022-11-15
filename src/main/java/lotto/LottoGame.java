package lotto;

import lotto.user.User;
import lotto.yield.Yield;

public class LottoGame {
    public void play() {
        try {
            User user = new User();
            user.buyLottos();
            user.printLottos();
            Yield yield = new Yield();
            yield.run(user);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
