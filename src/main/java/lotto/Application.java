package lotto;

import lotto.service.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoGame lottoGame = LottoGame.start();
            lottoGame.result();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
