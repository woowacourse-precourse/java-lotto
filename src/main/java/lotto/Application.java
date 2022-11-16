package lotto;

import lotto.controller.LottoGame;
import lotto.domain.Result;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame game = new LottoGame(new User(), new Result());
            game.run();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
