package lotto;

import java.util.List;

public class OutputView {

    public static void printLottos(List<Lotto> lottos, int amount) {
        System.out.println(Integer.toString(amount) + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
