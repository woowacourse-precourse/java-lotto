package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.run();
        } catch (IllegalArgumentException exception) {
            System.out.println("[ERROR]" + exception.getMessage());
        }
    }
}
