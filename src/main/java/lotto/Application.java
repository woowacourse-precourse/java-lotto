package lotto;

import lotto.game.LottoGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new LottoGame().start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
