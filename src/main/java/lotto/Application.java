package lotto;

import lotto.game.controller.Game;
import lotto.game.service.LottoService;

public class Application {
    public static void main(String[] args) {
        Game game = Game.create(new LottoService());
        game.start();
    }
}
