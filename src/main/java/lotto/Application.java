package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.buyLotto();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        lottoController.confirmPurchase();
        lottoController.setLuckyNumber();
        lottoController.checkWinningStatistics();

    }

}
