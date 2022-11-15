package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.LottoPrize;
import lotto.LottoScoreResult;

public class Output {
    private static final String OUTPUT_PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String OUTPUT_LOTTO_WIN_SCORE_RESULT_BONUSE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String OUPUT_WIN_STATUS_MESSAGE = "당첨 통계\n---";
    private static final String OUPUT_LOTTO_RETURN_RATE_MESSAGE = "총 수익률은 %.1f%%입니다";
    private static final int MAX_RANK = 5;

    public static void outputPurchaseLottoList(List<Lotto> lottos, int purchaseAmount) {
        System.out.printf(OUTPUT_PURCHASE_LOTTO_MESSAGE, purchaseAmount / 1000);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void outputLottoWinScoreResult(LottoScoreResult lottoScoreResult) {
        System.out.println(OUPUT_WIN_STATUS_MESSAGE);
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE, 3, LottoPrize.FIFTH_PRIZE.getLottotPrizeString(),
                lottoScoreResult.winScoreList.get(5));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE, 4, LottoPrize.FOURTH_PRIZE.getLottotPrizeString(),
                lottoScoreResult.winScoreList.get(4));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE, 5, LottoPrize.THIRD_PRIZE.getLottotPrizeString(),
                lottoScoreResult.winScoreList.get(3));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_BONUSE_MESSAGE, 5,
                LottoPrize.SECOND_PRIZE.getLottotPrizeString(), lottoScoreResult.winScoreList.get(2));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE, 6, LottoPrize.FIRST_PRIZE.getLottotPrizeString(),
                lottoScoreResult.winScoreList.get(1));
    }

    public static void ouputLottoReturnRate(double lottoReturnRate) {
        System.out.printf(OUPUT_LOTTO_RETURN_RATE_MESSAGE, lottoReturnRate);
    }

}
