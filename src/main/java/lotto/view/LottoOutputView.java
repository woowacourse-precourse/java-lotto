package lotto.view;

import lotto.domain.LottoResult;
import lotto.model.LottoBuyer;

import java.util.List;

public class LottoOutputView {
    private static String CONFIRM_BUY_AMOUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static String STATISTIC_MESSAGE = "당첨 통계\n---";
    LottoResult lottoResult = new LottoResult();

    public void printLottoStatistics(LottoBuyer lottoBuyer, List<Integer> winningNumbers, int bonusNumber) {
        System.out.println(STATISTIC_MESSAGE);
        lottoResult.getLottoStatistics(lottoBuyer, winningNumbers, bonusNumber);
    }

    public void printBuyAmount(LottoBuyer lottoBuyer) {
        System.out.printf(CONFIRM_BUY_AMOUNT_MESSAGE, lottoBuyer.getTotalLottoTickets());
    }

    public void printLottoInfo(LottoBuyer lottoBuyer) {
        lottoBuyer.getLottoTickets().forEach(lotto -> {
            List<Integer> lottoInfo = lotto.getLotto();
            System.out.println(lottoInfo);
        });
    }
}
