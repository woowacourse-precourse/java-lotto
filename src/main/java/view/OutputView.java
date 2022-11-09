package view;

import static view.MessageConstant.OUTPUT_PURCHASE;
import static view.MessageConstant.STATISTICS_MESSAGE;
import static view.MessageConstant.STATISTICS_THREE_MATCH;
import static view.MessageConstant.STATISTICS_FOUR_MATCH;
import static view.MessageConstant.STATISTICS_FIVE_MATCH;
import static view.MessageConstant.STATISTICS_FIVE_MATCH_ONE_BONUS;
import static view.MessageConstant.STATISTICS_SIX_MATCH;
import static view.MessageConstant.OUTPUT_EARNING;

public enum OutputView {
    INSTANCE;

    public void printPurchaseCount(int lottoCount){
        System.out.printf(OUTPUT_PURCHASE,lottoCount);
    }

    public void printStatistics(){
        System.out.println(STATISTICS_MESSAGE);
        System.out.println(STATISTICS_THREE_MATCH);
        System.out.println(STATISTICS_FOUR_MATCH);
        System.out.println(STATISTICS_FIVE_MATCH);
        System.out.println(STATISTICS_FIVE_MATCH_ONE_BONUS);
        System.out.println(STATISTICS_SIX_MATCH);
    }

    public void printEarning(float earning){
        System.out.printf(OUTPUT_EARNING,earning);
    }
}
