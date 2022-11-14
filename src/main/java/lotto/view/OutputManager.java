package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;

public class OutputManager {
    private static final String OUTPUT_MESSAGE_PURCHASE_AMOUNT = "개를 구매했습니다.";

    public OutputManager() {
    }
    public void printMessagePurchaseAmount(Lottos lottos) {
        int lottoCount = lottos.getLottos().size();
        System.out.println(lottoCount + OUTPUT_MESSAGE_PURCHASE_AMOUNT);
    }
    public void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
