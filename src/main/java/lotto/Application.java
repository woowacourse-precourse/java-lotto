package lotto;

import lotto.controller.LottoGameController;
import lotto.view.UserInput;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGameController lottoGameController = new LottoGameController();
            lottoGameController.run();
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR] " + exception.getMessage());
        }
    }
}
