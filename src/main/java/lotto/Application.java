package lotto;

import lotto.controller.LottoMachine;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMachine lottoMachine = new LottoMachine();
            lottoMachine.run();
        } catch (IllegalArgumentException error) {
            OutputView.printErrorMessage(error);
        }
    }
}
