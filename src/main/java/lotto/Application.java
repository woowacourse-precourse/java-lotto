package lotto;

import lotto.service.LottoManager;

public class Application {
    public static void main(String[] args) {
        try {
            LottoManager lottoManager = new LottoManager();
            lottoManager.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
