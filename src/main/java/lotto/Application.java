package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] = " + e.getMessage());
        }
    }
}
