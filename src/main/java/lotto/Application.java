package lotto;

import lotto.domain.LottoGame;
import lotto.exception.PayMoneyException;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        } catch (PayMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
}
