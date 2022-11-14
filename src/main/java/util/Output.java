package util;

import lotto.Lotteries;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.Match;

public class Output {
    public static void printCountOfLotteries(int lottoNum) {
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public static void printAllLotteries(Lotteries lotteries) {
        System.out.println(lotteries.getLottoNumbers());
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getLottoMatchCountByKey(Match.THREE) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getLottoMatchCountByKey(Match.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getLottoMatchCountByKey(Match.FIVE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getLottoMatchCountByKey(Match.FIVE_WITH_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getLottoMatchCountByKey(Match.SIX) + "개");
    }

    public static void printProfit(double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
