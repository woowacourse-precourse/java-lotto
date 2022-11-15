package lotto.view;

import java.util.List;
import lotto.utils.Constant;
import lotto.utils.Grade;

public class OutputView {
    public static void printTickets(List<List<Integer>> tickets){
        System.out.println(tickets.size() + Constant.PURCHASE_MESSAGE);
        tickets.stream().forEach(System.out::println);
        System.out.println();
    }
    public static void guideStatistics(){
        System.out.println(Constant.STATISTICS_TITLE);
        System.out.println(Constant.LINE);
    }
    public static void printReward(Grade grade, String Message, int count){
        System.out.println(grade.getCorrectLotto() + "개 일치" + Message +
                " (" + grade.getRewardFormat()+"원) - "+ count + "개");
    }

    public static void printProfitRate(long profit, long cost){
        profit = profit / Constant.PURCHASE_UNIT;
        cost = cost / Constant.PURCHASE_UNIT;
        double result = ((double)(profit * 100)) / ((double)cost);
        String rateFormat = String.format("%.1f", result);
        System.out.println("총 수익률은 " + rateFormat + "%입니다.");
    }
}
