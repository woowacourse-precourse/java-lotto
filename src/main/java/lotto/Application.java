package lotto;

import lotto.controller.LottoController;
import lotto.domain.player.Lottos;
import lotto.domain.game.generator.NumberGenerator;
import lotto.domain.game.generator.RandomNumberGenerator;
import lotto.domain.player.Player;
import lotto.domain.winner.LottoWinner;
import lotto.view.ExceptionView;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoController lottoController = new LottoController(new Player(), new Lottos(numberGenerator), new LottoWinner());

        try {
            lottoController.start();
        } catch (IllegalArgumentException e) {
            ExceptionView.print(e.getMessage());
        }
    }
}
