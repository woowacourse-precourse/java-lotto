package lotto;

import lotto.Controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        try {
            mainController.inputCash();
            mainController.createMyLottos();
            mainController.printMyLottos();

            mainController.inputWinningNumber();
            mainController.inputBonusNumber();
            mainController.calculateWinning();

            mainController.printResult();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
