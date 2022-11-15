package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class Output {
    private static final String buyLottoMessage = "개를 구매했습니다.";
    private static final String statisticsMessage = "당첨통계\n---";

    public static void outputBuyLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + buyLottoMessage);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
