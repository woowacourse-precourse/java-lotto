package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoStatics;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final static String NEW_LINE = "\n";
    private final static String PURCHASE_LOG = "%d개를 구매했습니다.";
    private final static String WIN_STATICS = "당첨 통계" + NEW_LINE + "---";

    public void print(List<Lotto> lotteries) {
        String purchaseLog = String.format(PURCHASE_LOG, lotteries.size());
        System.out.println(purchaseLog);
        lotteries.forEach(lotto -> System.out.println(lotto.toString()));
        System.out.print(NEW_LINE);
    }

    public void print(LottoStatics lottoStatics) {
        StringJoiner purchaseResult = new StringJoiner(NEW_LINE);
        purchaseResult.add(WIN_STATICS);
        purchaseResult.add(lottoStatics.getRankStaticsResult());
        purchaseResult.add(lottoStatics.getProfitRateResult());

        System.out.println(purchaseResult);
    }
}
