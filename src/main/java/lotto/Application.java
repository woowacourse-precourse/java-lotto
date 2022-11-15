package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController(new InputView(), new ResultView());
            controller.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}