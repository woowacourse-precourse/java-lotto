package lotto;

import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        try {
            lottoController.run();
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
