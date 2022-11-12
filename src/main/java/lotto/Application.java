package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.buyLotto();
            lottoController.checkLottoResult();
        } catch(IllegalArgumentException e){
            System.out.println("프로그램을 종료합니다.");
        }
    }
}
