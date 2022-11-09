package lotto;

import lotto.game.Game;
import lotto.game.LottoService;

public class Application {
    public static void main(String[] args) {
        Game game = Game.create(new LottoService());
        game.start();
    }
}
