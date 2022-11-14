package lotto.view;

import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String REQUEST_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String BUY_LOTTO_NUM_SUFFIX = "개를 구매했습니다.";
    private static final String REQUEST_INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String RESULT_HEAD = "당첨 통계\n---";
    private static final String RESULT_FIFTH_GRADE = "3개 일치 (5,000원) - ";
    private static final String RESULT_FOURTH_GRADE = "4개 일치 (50,000원) - ";
    private static final String RESULT_THIRD_GRADE = "5개 일치(1,500,000원) - ";
    private static final String RESULT_SECOND_GRADE = "5개 일치, 보너스 볼 일치(30,000,000원) - ";
    private static final String RESULT_FIRST_GRADE = "6개 일치 (2,000,000,000원) - ";
    private static final String PROFIT_PREFIX = "총 수익률은 ";
    private static final String PROFIT_SUFFIX = "%입니다.";


    public static void printGeneratedLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        System.out.println(numbers);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + BUY_LOTTO_NUM_SUFFIX);
    }

    public static void printString(String input) {
        System.out.println(input);
    }

    public static void printLineBreak() {
        System.out.println();
    }

}
