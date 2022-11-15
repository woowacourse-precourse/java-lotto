package lotto;

import lotto.user.User;
import lotto.yieldMachine.YieldMachine;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.play();
    }
}
