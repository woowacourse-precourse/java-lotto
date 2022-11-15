package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.Map;

public class OutputView {

    private static final String BUY_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";

    public static void buyLottoCount(int count) {
        System.out.println(count + BUY_LOTTO_COUNT_MESSAGE);
    }

    public static void showLottoTicket(LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getTicket()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void winStatistics(Map<LottoRank, Integer> winStat) {
        System.out.println(WIN_STATISTICS_MESSAGE);
        System.out.println("---");
        System.out.println(LottoRank.FIFTH.getMessage() + winStat.get(LottoRank.FIFTH) + "개");
        System.out.println(LottoRank.FORTH.getMessage() + winStat.get(LottoRank.FORTH) + "개");
        System.out.println(LottoRank.THIRD.getMessage() + winStat.get(LottoRank.THIRD) + "개");
        System.out.println(LottoRank.SECOND.getMessage() + winStat.get(LottoRank.SECOND) + "개");
        System.out.println(LottoRank.FIRST.getMessage() + winStat.get(LottoRank.FIRST) + "개");
    }

    public static void showRating(double rating) {
        System.out.println("총 수익률은 " + rating + "%입니다.");
    }
}
