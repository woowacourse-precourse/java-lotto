package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Lotto lotto = new Lotto(List.of(0, 1, 2, 3, 4, 5));
        lotto.startLotto();
    }
}
