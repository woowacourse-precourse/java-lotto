package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController.runGame();
        } catch (IllegalStateException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
