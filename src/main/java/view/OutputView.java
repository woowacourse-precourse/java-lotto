package view;

import model.Lotto;
import model.Lottos;

import java.util.List;

public class OutputView {
    public static final String LOTTOS_COUNT = "개를 구매했습니다.";

    public static void printLottos(Lottos inputLottos) {
        List<Lotto> lottos = inputLottos.getLottos();
        System.out.println(lottos.size() + LOTTOS_COUNT);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
