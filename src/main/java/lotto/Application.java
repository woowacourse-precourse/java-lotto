package lotto;

import lotto.domain.LottoProgram;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoProgram.init();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
