package lotto.view;

import lotto.model.LottoCount;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String NUMBER_OF_PURCHASED_LOTTOS = "%d개를 구매했습니다.";

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.print(NEW_LINE);
        System.out.printf(NUMBER_OF_PURCHASED_LOTTOS, lottoCount.getLottoCount());
    }
}
