package lotto;

import lotto.controller.LottoGame;
import lotto.domain.Result;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame game = new LottoGame(new User(), new Result());
        game.run();
    }
}
