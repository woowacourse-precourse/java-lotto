package lotto.view;

import lotto.constant.Rank;
import lotto.model.Lotto;
import lotto.model.LottoStatistics;

import java.util.List;

public class ResultView {
    private static final String BUY_COUNT_MESSAGE_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_PRINT_FORMAT = "[%d, %d, %d, %d, %d, %d]\n";

    private static final String FIRST_PRICE = "2,000,000,000";
    private static final String SECOND_PRICE = "30,000,000";
    private static final String THIRD_PRICE = "1,500,000";
    private static final String FOURTH_PRICE = "50,000";
    private static final String FIFTH_PRICE = "5,000";

    private static final String STATISTIC_FORMAT = "당첨 통계\n---\n" +
            "3개 일치 (%s원) - %d개\n" +
            "4개 일치 (%s원) - %d개\n" +
            "5개 일치 (%s원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (%s원) - %d개\n"+
            "6개 일치 (%s원) - %d개\n"+
            "총 수익률은 %.1f";


    public static void printLottoCount(int buyCount){
        System.out.printf(BUY_COUNT_MESSAGE_FORMAT, buyCount);
    }

    public static void printLottoList(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.printf(LOTTO_PRINT_FORMAT, numbers.get(0), numbers.get(1), numbers.get(2),numbers.get(3),numbers.get(4),numbers.get(5));
        }
        System.out.println();
    }

    public static void printStatistics(){
        System.out.printf(STATISTIC_FORMAT,
                FIFTH_PRICE, LottoStatistics.rankMap.get(Rank.FIVE),
                FOURTH_PRICE, LottoStatistics.rankMap.get(Rank.FOUR),
                THIRD_PRICE, LottoStatistics.rankMap.get(Rank.THREE),
                SECOND_PRICE, LottoStatistics.rankMap.get(Rank.TWO),
                FIRST_PRICE, LottoStatistics.rankMap.get(Rank.ONE),
                LottoStatistics.revenueRate
        );
        System.out.println("%입니다.");
    }
}
