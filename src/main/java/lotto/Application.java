package lotto;

import static lotto.domain.StartLotto.startLotto;

public class Application {
    public static void main(String[] args) {
        try {
            startLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
