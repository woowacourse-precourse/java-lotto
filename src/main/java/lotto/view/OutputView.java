package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String UNIT = "개";
    private static final String BUY_LOTTO_NUM_SUFFIX = "개를 구매했습니다.";
    private static final String RESULT_HEAD = "당첨 통계\n---";
    private static final String RESULT_FIFTH_GRADE = "3개 일치 (5,000원) - ";
    private static final String RESULT_FOURTH_GRADE = "4개 일치 (50,000원) - ";
    private static final String RESULT_THIRD_GRADE = "5개 일치 (1,500,000원) - ";
    private static final String RESULT_SECOND_GRADE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String RESULT_FIRST_GRADE = "6개 일치 (2,000,000,000원) - ";
    private static final String PROFIT_PREFIX = "총 수익률은 ";
    private static final String PROFIT_SUFFIX = "%입니다.";


    public static void printGeneratedLottoNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + BUY_LOTTO_NUM_SUFFIX);
    }

    public static void printResult(LottoResult result) {
        System.out.println(RESULT_HEAD);
        System.out.println(RESULT_FIFTH_GRADE + result.getCount(Rank.FIFTH) + UNIT);
        System.out.println(RESULT_FOURTH_GRADE + result.getCount(Rank.FOURTH) + UNIT);
        System.out.println(RESULT_THIRD_GRADE + result.getCount(Rank.THIRD) + UNIT);
        System.out.println(RESULT_SECOND_GRADE + result.getCount(Rank.SECOND) + UNIT);
        System.out.println(RESULT_FIRST_GRADE + result.getCount(Rank.FOURTH) + UNIT);
    }

    public static void printProfit(double profit) {
        System.out.println(PROFIT_PREFIX + profit + PROFIT_SUFFIX);
    }

    public static void printString(String input) {
        System.out.println(input);
    }

    public static void printLineBreak() {
        System.out.println();
    }

}
