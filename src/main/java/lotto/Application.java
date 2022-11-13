package lotto;

import lotto.config.LottoDependencyManager;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoDependencyManager dependencyManager = new LottoDependencyManager();

        ResultView resultView = dependencyManager.resultView();
        InputView inputView = dependencyManager.inputView();
        LottoApplication lottoApplication = new LottoApplication(inputView, resultView);

        try {
            lottoApplication.run();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
