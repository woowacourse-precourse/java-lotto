package lotto;

import lotto.domain.LottoController;
import lotto.domain.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
