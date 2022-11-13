package lotto;

import lotto.controller.LottoController;
import lotto.view.UserInterface;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.gameStart();
    }
}
