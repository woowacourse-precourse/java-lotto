package lotto;

import lotto.Controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        try {
            mainController.inputCash();
            mainController.createMyLottos();

            mainController.inputWinningNumber();
            mainController.inputBonusNumber();

            mainController.calculateWinning();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
