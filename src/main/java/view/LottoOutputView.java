package view;

import static model.LottoMachineConstants.*;
import static view.LottoOutputViewConstants.*;

import java.util.Map;

import model.Lotto;

public class LottoOutputView {

	public void showLotto(Lotto lotto) {
		System.out.println(lotto.getNumbers());
	}

	public void showLottoCount(long totalLottoCount) {
		System.out.println("\n" + totalLottoCount + "개를 구매했습니다.");
	}

	public void showLottoProfit(double profit) {
		System.out.println(String.format(LOTTO_OUTPUT_TOTAL_PROFIT, profit) + "입니다.");
	}

	public void showWinningResult(Map<Integer, Integer> lottoWinningStatistics) {
		System.out.println(LOTTO_OUTPUT_STATISTICS);
		System.out.println(LOTTO_OUTPUT_THREE_SAME + lottoWinningStatistics.get(RANK_FIFTH) + "개");
		System.out.println(LOTTO_OUTPUT_FOUR_SAME + lottoWinningStatistics.get(RANK_FOURTH) + "개");
		System.out.println(LOTTO_OUTPUT_FIVE_SAME_NO_BONUS + lottoWinningStatistics.get(RANK_THIRD) + "개");
		System.out.println(LOTTO_OUTPUT_FIVE_SAME_BONUS + lottoWinningStatistics.get(RANK_SECOND) + "개");
		System.out.println(LOTTO_OUTPUT_SIX_SAME + lottoWinningStatistics.get(RANK_FIRST) + "개");
	}
}