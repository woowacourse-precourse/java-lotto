package lotto;

import lotto.controller.LottoController;
import lotto.domain.Statistics;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController(new Statistics());
        controller.run();
    }
}
