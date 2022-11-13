package lotto.view;

import java.util.Map;

public class OutputView {

    private static final String buyLottoCountMessage = "개를 구매했습니다.";
    private static final String winStatisticsMessage = "당첨 통계.";
    private static final String threeSameNumberMessage = "3개 일치 (5,000원) - ";
    private static final String fourSameNumberMessage = "4개 일치 (50,000원) - ";
    private static final String fiveSameNumberMessage = "5개 일치 (1,500,000원) - ";
    private static final String fiveAndBonusSameNumberMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String sixSameNumberMessage = "6개 일치 (2,000,000,000원) - ";

    public static void buyLottoCount(int count) {
        System.out.println(count + buyLottoCountMessage);
    }

    public static void winStatistics(Map<Integer, Integer> winStat) {
        System.out.println(winStatisticsMessage);
        System.out.println("---");
        System.out.println(threeSameNumberMessage + winStat.get(5) + "개");
        System.out.println(fourSameNumberMessage + winStat.get(4) + "개");
        System.out.println(fiveSameNumberMessage + winStat.get(3) + "개");
        System.out.println(fiveAndBonusSameNumberMessage + winStat.get(2) + "개");
        System.out.println(sixSameNumberMessage + winStat.get(1) + "개");
    }

    public static void showRating(float rating) {
        System.out.println("총 수익률은 " + rating + "입니다.");
    }
}
