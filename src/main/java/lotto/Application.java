package lotto;

import lotto.controller.LottoGameSimulator;

public class Application {
    public static void main(String[] args) {
        LottoGameSimulator lottoGameSimulator = new LottoGameSimulator();
        lottoGameSimulator.run();
    }
}
