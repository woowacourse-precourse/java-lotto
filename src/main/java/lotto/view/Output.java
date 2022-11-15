package lotto.view;

import lotto.model.Rank;

import java.util.List;
import java.util.Map;

import static lotto.model.Rank.*;

public class Output {
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String COUNT_LOTTO_MESSAGE = "%d개 구매했습니다.\n";
    public static final String INPUT_PRIZE_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.\n";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATISTICS_MESSAGE = "당첨 통계\n---";
    public static final String FIRST_STATISTICS_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    public static final String SECOND_STATISTICS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    public static final String THIRD_STATISTICS_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    public static final String FOURTH_STATISTICS_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    public static final String FIFTH_STATISTICS_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    public static final String YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";


    public static void printInputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
    }

    public static void printCountLotto(int countLotto) {
        System.out.printf(COUNT_LOTTO_MESSAGE, countLotto);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printInputPrizeNumbers() {
        System.out.println(INPUT_PRIZE_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printWinStatistics(Map<Rank, Integer> winStatistics) {
        System.out.println(WIN_STATISTICS_MESSAGE);

        System.out.printf(FIFTH_STATISTICS_MESSAGE, winStatistics.get(FIFTH));
        System.out.printf(FOURTH_STATISTICS_MESSAGE, winStatistics.get(FOURTH));
        System.out.printf(THIRD_STATISTICS_MESSAGE, winStatistics.get(THIRD));
        System.out.printf(SECOND_STATISTICS_MESSAGE, winStatistics.get(SECOND));
        System.out.printf(FIRST_STATISTICS_MESSAGE, winStatistics.get(FIRST));
    }

    public static void printYield(double yield){
        System.out.printf(YIELD_MESSAGE, yield);
    }
}
