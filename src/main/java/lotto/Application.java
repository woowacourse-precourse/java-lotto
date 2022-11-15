package lotto;

import lotto.controller.LottoController;
import lotto.service.Reward;

public class Application {
    public static void main(String[] args) {
        new LottoController().run();
    }
}
