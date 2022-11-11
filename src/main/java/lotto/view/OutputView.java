package lotto.view;

import java.util.List;

import static lotto.constant.MessageConstant.OUTPUT_PURCHASE;
import static lotto.constant.MessageConstant.STATISTICS_MESSAGE;
import static lotto.constant.MessageConstant.STATISTICS_THREE_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FOUR_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FIVE_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FIVE_MATCH_ONE_BONUS;
import static lotto.constant.MessageConstant.STATISTICS_SIX_MATCH;
import static lotto.constant.MessageConstant.OUTPUT_EARNING;

public class OutputView {

    public void printPurchaseCount(int lottoCount){
        System.out.printf(OUTPUT_PURCHASE,lottoCount);
    }

    public void printStatistics(List<Integer> lottoStatistics){
        System.out.println(STATISTICS_MESSAGE);
        System.out.printf(STATISTICS_THREE_MATCH, lottoStatistics.get(0));
        System.out.printf(STATISTICS_FOUR_MATCH, lottoStatistics.get(1));
        System.out.printf(STATISTICS_FIVE_MATCH, lottoStatistics.get(2));
        System.out.printf(STATISTICS_FIVE_MATCH_ONE_BONUS, lottoStatistics.get(3));
        System.out.printf(STATISTICS_SIX_MATCH, lottoStatistics.get(4));
    }

    public void printEarning(float earning){
        System.out.printf(OUTPUT_EARNING,earning);
    }
}
