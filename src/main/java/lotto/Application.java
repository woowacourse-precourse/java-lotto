package lotto;

import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.lottoStart();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
