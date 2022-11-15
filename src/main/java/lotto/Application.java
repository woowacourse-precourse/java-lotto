package lotto;

import lotto.domain.LottoApplication;

public class Application {
    public static void main(String[] args) {
        try {
            LottoApplication lottoApplication = new LottoApplication();
            lottoApplication.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}