package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.LottoPrize;
import lotto.LottoScoreResult;

public class Output {
    private static final String OUTPUT_PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String OUTPUT_LOTTO_WIN_SCORE_RESULT_BONUSE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String OUPUT_WIN_STATUS_MESSAGE = "당첨 통계\n---";
    private static final int MAX_RANK = 5;
    public static void outputPurchaseLottoList(List<Lotto> lottos) {
        System.out.println(OUTPUT_PURCHASE_LOTTO_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void outputLottoWinScoreResult(LottoScoreResult lottoScoreResult) {
        System.out.println(OUPUT_WIN_STATUS_MESSAGE);
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE,3, LottoPrize.FIFTH_PRIZE.getLottotPrizeString(),lottoScoreResult.winScoreList.get(5));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE,4, LottoPrize.FOURTH_PRIZE.getLottotPrizeString(),lottoScoreResult.winScoreList.get(4));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE,5, LottoPrize.THIRD_PRIZE.getLottotPrizeString(),lottoScoreResult.winScoreList.get(3));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_BONUSE_MESSAGE,5, LottoPrize.SECOND_PRIZE.getLottotPrizeString(),lottoScoreResult.winScoreList.get(2));
        System.out.printf(OUTPUT_LOTTO_WIN_SCORE_RESULT_MESSAGE,6, LottoPrize.FIFTH_PRIZE.getLottotPrizeString(),lottoScoreResult.winScoreList.get(1));
    }

}
