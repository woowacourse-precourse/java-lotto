package lotto;

import controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();
        try {
            lottoGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
