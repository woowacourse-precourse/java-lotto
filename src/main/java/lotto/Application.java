package lotto;

import lotto.application.in.starter.LottoStarter;

public class Application {
    public static void main(String[] args) {
        LottoStarter lottoStarter = new LottoStarter();
        try {
            lottoStarter.start();
        } catch (IllegalArgumentException exception) {}
    }
}
