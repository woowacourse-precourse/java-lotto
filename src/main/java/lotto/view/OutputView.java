package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    private final static String PURCHASE_LOG = "%d개를 구매했습니다.";

    public void printLotteries(List<Lotto> lotteries) {
        String purchaseLog = String.format(PURCHASE_LOG, lotteries.size());
        System.out.println(purchaseLog);
        lotteries.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
