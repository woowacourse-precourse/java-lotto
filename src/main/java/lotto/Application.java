package lotto;

import lotto.controller.LottoManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManager lottoManager = new LottoManager();
        try {
            lottoManager.startLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
