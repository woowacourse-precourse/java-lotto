package lotto;

import lotto.controller.LottoGame;
import lotto.domain.Customer;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.play(new Customer());
    }
}
