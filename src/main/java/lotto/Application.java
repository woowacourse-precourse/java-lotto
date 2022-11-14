package lotto;

import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        try {
            lottoController.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
