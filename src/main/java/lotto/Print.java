package lotto;

import java.util.List;
import java.util.Map;

public class Print {
    public void userLotto(int money) {
        int lottoAmount = money/1000;
        for (int i = 0; i < lottoAmount; i++) {
            System.out.println(Lotto.create());
        }
    }
}
