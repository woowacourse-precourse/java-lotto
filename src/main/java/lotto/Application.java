package lotto;

import lotto.ui.LottoSimulator;

public class Application {
    public static void main(String[] args) {
        try {
            LottoSimulator lottoSimulator = new LottoSimulator();
            lottoSimulator.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
