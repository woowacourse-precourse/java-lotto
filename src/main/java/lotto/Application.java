package lotto;

import Controller.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.gameStart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
