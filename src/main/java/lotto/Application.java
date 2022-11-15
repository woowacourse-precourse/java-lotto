package lotto;

import lotto.domain.Game;
public class Application {
    public static void main(String[] args) {
        try {
            Game lottoGame = new Game();
            lottoGame.run();
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
