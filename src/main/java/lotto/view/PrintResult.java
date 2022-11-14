package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class PrintResult {

    private static final String PIECES_COUNT_MENT = "개를 구매했습니다.";
    private static final String WINNINGMENT_START = "당첨 통계";
    private static final String LINE = "---";
    private static final String RANKCOUNT_FORMAT = "%s (%s원) - %s개";
    private static final String PROFITRATE_FORMAT = "총 수익률은 %s%%입니다.";


    public static void PrintPieces(int pieces) {
        System.out.println(pieces + PIECES_COUNT_MENT);
    }

    public static void PrintLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void PrintPrizeStatistic(Map<Prize, Integer> prizeBoard) {
        System.out.println(WINNINGMENT_START);
        System.out.println(LINE);
        System.out.println(
            String.format(RANKCOUNT_FORMAT, "3개 일치", "5,000", prizeBoard.get(Prize.THREE)));
        System.out.println(
            String.format(RANKCOUNT_FORMAT, "4개 일치", "50,000", prizeBoard.get(Prize.FOUR)));
        System.out.println(
            String.format(RANKCOUNT_FORMAT, "5개 일치", "1,500,000", prizeBoard.get(Prize.FIVE)));
        System.out.println(String.format(RANKCOUNT_FORMAT, "5개 일치, 보너스 볼 일치", "30,000,000",
            prizeBoard.get(Prize.FIVE_AND_BOUNS)));
        System.out.println(
            String.format(RANKCOUNT_FORMAT, "6개 일치", "2,000,000,000", prizeBoard.get(Prize.ALL)));
    }

    public static void PrintProfitRate(float profitRate) {
        System.out.println(String.format(PROFITRATE_FORMAT, profitRate));
    }

}
