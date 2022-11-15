package lotto;

import lotto.logic.Exchanger;
import lotto.logic.LottoMachine;
import lotto.logic.LottoService;
import lotto.view.View;

public class Application {

    public static void main(String[] args) {
        LottoMachine lottoMachine = LottoMachine.getInstance();
        LottoService lottoService = LottoService.getInstance();
        Exchanger exchanger = Exchanger.getInstance();
        View view = View.getInstance();
        Game game = new Game(lottoMachine, lottoService, exchanger, view);

        try {
            game.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
