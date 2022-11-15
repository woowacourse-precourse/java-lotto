package lotto;

import lotto.domain.LottoProgram;

public class Application {
    public static void main(String[] args) {
        try {
            LottoProgram.init();
        } catch (IllegalArgumentException e) {
            Display.error(e);
        }
    }
}
