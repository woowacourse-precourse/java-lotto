package lotto;

import lotto.service.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = LottoGame.start();
            lottoGame.result();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
