package lotto;

import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGameController.run();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
