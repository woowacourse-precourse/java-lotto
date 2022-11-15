package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinRank;
import lotto.view.util.OutputUtil;

public class UserOutput {
    private static final String OUTPUT_BUY_LOTTOS = "개를 구매했습니다.";
    private static final String OUTPUT_WIN_STATISTICS = "당첨 통계\n---";
    private static final String OUTPUT_EARNING_RATE = "총 수익률은 ";
    private static final String OUTPUT_PERCENT = "%입니다.";

    public static void outputBuyLottos(Lottos lottos) {
        System.out.println("\n" + lottos.getLottos().size() + OUTPUT_BUY_LOTTOS);

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto().toString());
        }

        System.out.println();
    }

    public static void outputResultStatistics(Result result, Integer inputMoney) {
        System.out.println(OUTPUT_WIN_STATISTICS);
        outputWinStatistics(result);
        outputEarningRate(result, inputMoney);
    }

    private static void outputWinStatistics(Result result) {
        final Map<WinRank, Integer> prizeResult = result.getPrizeResult();

        for (WinRank winRank : WinRank.getWinnerRanksExceptFail()) {
            System.out.println(getEachWinStatistics(winRank, prizeResult));
        }

    }

    private static void outputEarningRate(Result result, Integer inputMoney) {
        System.out.println(OUTPUT_EARNING_RATE + result.calculateEarningRate(inputMoney) + OUTPUT_PERCENT);
    }

    private static String getEachWinStatistics(WinRank winRank, Map<WinRank, Integer> prizeResult) {
        final String PRIZE_MESSAGE = "개 일치 (";
        final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (";
        final String WON_MESSAGE = "원) - ";
        final String COUNT_MESSAGE = "개";
        final String PRIZE_WITH_COMMA = OutputUtil.IntegerToStringWithComma(winRank.getPrize());

        if (winRank.equals(WinRank.SECOND)) {
            return SECOND_PRIZE_MESSAGE + PRIZE_WITH_COMMA + WON_MESSAGE
                    + prizeResult.get(winRank).toString() + COUNT_MESSAGE;
        }
        return winRank.getMatched() + PRIZE_MESSAGE + PRIZE_WITH_COMMA + WON_MESSAGE
                + prizeResult.get(winRank).toString() + COUNT_MESSAGE;
    }
}
