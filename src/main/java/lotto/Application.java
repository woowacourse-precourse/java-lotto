package lotto;

import lotto.controller.LottoController;
import lotto.view.Output;

public class Application {

    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController(new Output());
            controller.run();
        } catch (IllegalArgumentException exception) {
        }
    }
}