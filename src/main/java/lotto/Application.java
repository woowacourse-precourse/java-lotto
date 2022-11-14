package lotto;

import lotto.controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
