package lotto;

import lotto.game.controller.Game;
import lotto.game.service.LottoService;
import lotto.game.view.UI;

public class Application {
    public static void main(String[] args) {
        Game game = Game.create(new LottoService(), new UI());
        try {
            game.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
