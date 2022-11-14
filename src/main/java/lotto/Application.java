package lotto;

import lotto.controller.LottoController;
import lotto.view.UserInterface;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController();
            controller.gameStart();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}
