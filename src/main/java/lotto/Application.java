package lotto;

import lotto.controller.LottoController;
import lotto.view.Message;
import lotto.view.UserInterface;

public class Application {

    public static void main(String[] args) {
        try {
            LottoController controller = new LottoController();
            controller.gameStart();
        } catch (IllegalArgumentException e) {
            System.out.println(Message.ERROR_MESSAGE + e.getMessage());
        }
    }
}
