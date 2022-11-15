package lotto;

import lotto.domain.Game;
import lotto.exception.LottoException;

public class Application {
    public static void main(String[] args) {
        try {
            Game game = new Game();
            game.start();
        }catch (LottoException e){
            System.out.println(e);
        }
    }
}
