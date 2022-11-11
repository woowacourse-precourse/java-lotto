package lotto;

import lotto.controller.LottoController;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController();

            controller.showIntroduce();
            controller.showMoneyInput();
            controller.showLottoPurchaseNumbers();
            controller.showLottoNumberInput();
            controller.showBonusNumberInput();
            controller.showLottoStatistic();

        } catch (IllegalArgumentException exception) {
            View.printLine("[ERROR ]" + exception.getMessage());

            throw exception;
        }
    }
}
