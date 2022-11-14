package lotto;

import static lotto.util.LottoUtils.start;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
