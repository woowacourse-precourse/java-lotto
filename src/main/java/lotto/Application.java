package lotto;

import lotto.domain.LottoLauncher;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoLauncher lottoLauncher = new LottoLauncher();

        try {
            lottoLauncher.startLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
