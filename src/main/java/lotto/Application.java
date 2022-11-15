package lotto;

import lotto.config.LottoConfig;

public class Application {

    public static void main(String[] args) {
        try {
            LottoConfig.config().play();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
