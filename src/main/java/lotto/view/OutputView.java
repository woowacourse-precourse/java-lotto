package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Calculator;
import lotto.domain.Rank;

public class OutputView {
    private static final String UNIT = "개";
    private static final String MESSAGE_BUY_SUFFIX = "를 구매했습니다.";
    private static final String MESSAGE_OUTPUT_INIT = "당첨 통계\n---";
    private static final String MESSAGE_PROFIT_PREFIX = "총 수익률은 ";
    private static final String MESSAGE_PROFIT_SUFFIX = "%입니다.";
    private static final String MESSAGE_FIFTH_GRADE = "3개 일치 (5,000원) - ";
    private static final String MESSAGE_FOURTH_GRADE = "4개 일치 (50,000원) - ";
    private static final String MESSAGE_THIRD_GRADE = "5개 일치 (1,500,000원) - ";
    private static final String MESSAGE_SECOND_GRADE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String MESSAGE_FIRST_GRADE = "6개 일치 (2,000,000,000원) - ";

    public static void printLotteryCount(Integer count) {
        System.out.println(count.toString() + UNIT + MESSAGE_BUY_SUFFIX);
    }

    public static void printCreatedNumbers(List<Integer> numbers) {
        List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);
    }

    public static void printWinningInfo(Calculator rankCountMap) {
        System.out.println(MESSAGE_OUTPUT_INIT);
        System.out.println(MESSAGE_FIFTH_GRADE + rankCountMap.getCount(Rank.FIFTH) + UNIT);
        System.out.println(MESSAGE_FOURTH_GRADE + rankCountMap.getCount(Rank.FOURTH) + UNIT);
        System.out.println(MESSAGE_THIRD_GRADE + rankCountMap.getCount(Rank.THIRD) + UNIT);
        System.out.println(MESSAGE_SECOND_GRADE + rankCountMap.getCount(Rank.SECOND) + UNIT);
        System.out.println(MESSAGE_FIRST_GRADE + rankCountMap.getCount(Rank.FIRST) + UNIT);
    }

    public static void printProfit(double profit) {
        System.out.println(MESSAGE_PROFIT_PREFIX + Double.toString(profit) + MESSAGE_PROFIT_SUFFIX);
    }

    public static void printString(String input){
        System.out.println(input);
    }

    public static void enterLine(){
        System.out.println();
    }
}
