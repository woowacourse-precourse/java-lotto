package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.Map;

public class OutputView {

    private static final String BUY_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WIN_STATISTICS_MESSAGE = "당첨 통계";
    private static final String THREE_SAME_NUMBER_MESSAGE = "3개 일치 (5,000원) - ";
    private static final String FOUR_SAME_NUMBER_MESSAGE = "4개 일치 (50,000원) - ";
    private static final String FIVE_SAME_NUMBER_MESSAGE = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_SAME_NUMBER_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_SAME_NUMBER_MESSAGE = "6개 일치 (2,000,000,000원) - ";

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
        System.out.println(THREE_SAME_NUMBER_MESSAGE + winStat.get(LottoRank.FIFTH) + "개");
        System.out.println(FOUR_SAME_NUMBER_MESSAGE + winStat.get(LottoRank.FORTH) + "개");
        System.out.println(FIVE_SAME_NUMBER_MESSAGE + winStat.get(LottoRank.THIRD) + "개");
        System.out.println(FIVE_AND_BONUS_SAME_NUMBER_MESSAGE + winStat.get(LottoRank.SECOND) + "개");
        System.out.println(SIX_SAME_NUMBER_MESSAGE + winStat.get(LottoRank.FIRST) + "개");
    }

    public static void showRating(double rating) {
        System.out.println("총 수익률은 " + rating + "%입니다.");
    }
}
