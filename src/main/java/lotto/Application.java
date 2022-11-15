package lotto;

import lotto.Controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 에러가 발생하여 종료합니다.");
        }
    }
}