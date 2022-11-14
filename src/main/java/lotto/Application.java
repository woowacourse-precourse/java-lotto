package lotto;

import lotto.controller.InputController;
import lotto.controller.OutputController;
import lotto.util.Lang;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        try {
            loadControllers();
        } catch (Exception exception) {
            errorMessage(exception);
        }
    }

    private static void loadControllers() {
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();
        outputController.showIntroduce();
        inputController.showMoneyInput();
        outputController.showLottoPurchaseNumbers();
        inputController.showLottoNumberInput();
        inputController.showBonusNumberInput();
        outputController.showLottoStatistic();
    }

    private static void errorMessage(Exception exception) {
        View.printLine(Lang.format(
                "%s %s",
                Lang.VIEW_ERROR,
                exception.getMessage()));
    }
}
