package lotto.view;

import lotto.domain.WinningNumberStatus;
import lotto.domain.Lotto;
import lotto.dto.ResultResponse;
import java.util.List;

import static lotto.domain.NoticeMessage.*;

public class OutputView {
    public void outputLotto(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + LOTTO_COUNT.toString());
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.getNumbers());
        }
        System.out.println();
    }

    public void outputWinningStatistics(ResultResponse result) {
        System.out.println(WINNING_STATISTICS);
        for (int rank = WinningNumberStatus.FIFTH.getOrder(); rank >= WinningNumberStatus.FIRST.getOrder(); rank--) {
            System.out.println(printWinningStatistics(result, rank));
        }
    }

    public void outputEarningRate(double earningRate) {
        System.out.println(printEarningRate(earningRate));
    }

}
