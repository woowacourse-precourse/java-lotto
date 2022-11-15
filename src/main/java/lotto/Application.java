package lotto;

import lotto.Controller.InputOutputController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputOutputController inputOutputController = new InputOutputController();
        inputOutputController.inputMoney();
        inputOutputController.outputLottoSize();
        inputOutputController.inputWinningNumbers();
        inputOutputController.inputBonusNumber();
        inputOutputController.checkLottoNumbers();
        inputOutputController.calculatedYield();
    }
}
