package lotto;

import controller.LottoController;

public class Application {
    public static void main(String[] args) {

        LottoController lottoController = new LottoController();

        try {
            lottoController.purchase();
            lottoController.purchaseList();
            lottoController.winnerNumber();
            lottoController.bonusNumber();
            lottoController.statistics();
        } catch (IllegalArgumentException e) {
            recordException(e.getMessage());
        }

    }

    private static void recordException(String message) {
        System.out.println(message);
    }
}
