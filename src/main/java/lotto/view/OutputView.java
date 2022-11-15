package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String AMOUNT_OF_LOTTO = "\n%d개를 구매했습니다.\n";

    public static final String RESULT_OF_LOTTO = "당첨 통계 \n" + "---";
    public static final String RESULT_CORRECT_THREE_NUMBERS = "3개 일치 (5,000원) - %d개";
    public static final String RESULT_CORRECT_FOUR_NUMBERS = "4개 일치 (50,000원) - %d개";
    public static final String RESULT_CORRECT_FIVE_NUMBERS = "5개 일치 (1,500,000원) - %d개";
    public static final String RESULT_CORRECT_FIVE_AND_BONUS_NUMBERS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    public static final String RESULT_CORRECT_SIX_NUMBERS = "6개 일치 (2,000,000,000원) - %d개";
    public static final String RESULT_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printAmount(Integer amount) {
        System.out.printf(AMOUNT_OF_LOTTO, amount);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printLottoResult(Map<Rank, Integer> lottoResult, double profitRate) {
        System.out.println(RESULT_OF_LOTTO);
        System.out.println(String.format(RESULT_CORRECT_THREE_NUMBERS, lottoResult.get(Rank.FIFTH)));
        System.out.println(String.format(RESULT_CORRECT_FOUR_NUMBERS, lottoResult.get(Rank.FOURTH)));
        System.out.println(String.format(RESULT_CORRECT_FIVE_NUMBERS, lottoResult.get(Rank.THIRD)));
        System.out.println(String.format(RESULT_CORRECT_FIVE_AND_BONUS_NUMBERS, lottoResult.get(Rank.SECOND)));
        System.out.println(String.format(RESULT_CORRECT_SIX_NUMBERS, lottoResult.get(Rank.FIRST)));
        System.out.println(String.format(RESULT_PROFIT_RATE, profitRate));
    }
}
