package lotto;

import lotto.controller.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        try{
            game.startLottoGame();
        }catch (IllegalArgumentException ex) {
        }
    }
}
