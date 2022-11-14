package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController gamController = new LottoController();

        try {
            gamController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
}
