package lotto;

import lotto.controller.LottoController;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class Application {
    public static void main(String[] args) {
        LottoOutputView lottoOutputView = new LottoOutputView();
        LottoInputView lottoInputView = new LottoInputView();
        LottoController gamController = new LottoController(lottoInputView, lottoOutputView);

        try {
            gamController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}
