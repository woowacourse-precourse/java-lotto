package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    public static void informPurchaseCount(Lottos lottos) {
        int count = lottos.countTotal();
        System.out.println(String.format("%d개를 구매했습니다.", count));
    }
}
