package lotto.view;

import static lotto.constant.MessageConstant.OUTPUT_PURCHASE;
import static lotto.constant.MessageConstant.STATISTICS_MESSAGE;
import static lotto.constant.MessageConstant.STATISTICS_THREE_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FOUR_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FIVE_MATCH;
import static lotto.constant.MessageConstant.STATISTICS_FIVE_MATCH_ONE_BONUS;
import static lotto.constant.MessageConstant.STATISTICS_SIX_MATCH;
import static lotto.constant.MessageConstant.OUTPUT_EARNING;

public enum OutputView {
    INSTANCE;

    public void printPurchaseCount(int lottoCount){
        System.out.printf(OUTPUT_PURCHASE,lottoCount);
    }

    public void printStatistics(int three, int four, int five, int fiveAndBonus, int six){
        System.out.println(STATISTICS_MESSAGE);
        System.out.printf(STATISTICS_THREE_MATCH, three);
        System.out.printf(STATISTICS_FOUR_MATCH, four);
        System.out.printf(STATISTICS_FIVE_MATCH, five);
        System.out.printf(STATISTICS_FIVE_MATCH_ONE_BONUS, fiveAndBonus);
        System.out.printf(STATISTICS_SIX_MATCH, six);
    }

    public void printEarning(float earning){
        System.out.printf(OUTPUT_EARNING,earning);
    }
}
