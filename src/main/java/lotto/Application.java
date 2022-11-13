package lotto;

import controller.LottoGameController;
import view.LottoGameInputView;
import view.LottoGameOutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController gameController = new LottoGameController(LottoGameInputView.getInstance(),
                LottoGameOutputView.getInstance());
        gameController.run();
    }
}
