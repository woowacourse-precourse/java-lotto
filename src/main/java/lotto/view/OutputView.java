package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_PURCHASE_MESSAGE = "8개를 구매했습니다.";

    public void outputUserLottos(List<Lotto> userLottos) {
        System.out.println();
        System.out.println(OUTPUT_PURCHASE_MESSAGE);
        for (Lotto lotto : userLottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
