package lotto.view;

import lotto.domain.TotalLotto;

public class OutputView {

    private static final String BUYING_LOTTO = "%d개를 구매했습니다.";
    private static final String NEXT_LINE = "\n";

    public void printMessage(final String message) {
        System.out.println(message);

    }

    public void printBuyingLottos(final TotalLotto totalLotto) {
        System.out.println();
        System.out.printf(BUYING_LOTTO + NEXT_LINE, totalLotto.getLottoCount());
        System.out.println(totalLotto);
    }
}
