package lotto;

import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        try {
            LottoController game = new LottoController();
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
