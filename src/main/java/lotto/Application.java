package lotto;

import lotto.controller.FrontController;
import lotto.domain.Lotto;
import lotto.domain.LottoStats;
import lotto.domain.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        FrontController frontController = configuration();
        frontController.run();
    }
    public static FrontController configuration(){
        return new FrontController(
                new InputView(),new OutputView(),new Purchase(),new LottoStats());
    }
}
