package lotto;

import lotto.controller.LottoSystemController;

public class Application {
    public static void main(String[] args) {
        LottoSystemController lottoSystemController = new LottoSystemController();
        lottoSystemController.run();
    }
}
