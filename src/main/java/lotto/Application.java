package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        LottoApplication lottoApplication = new LottoApplication(inputView, resultView);

        lottoApplication.run();
    }
}
