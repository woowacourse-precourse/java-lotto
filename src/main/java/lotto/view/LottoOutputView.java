package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class LottoOutputView {
    private final static String LOTTO_COUNT_STRING = "개를 구매했습니다.";
    private final static String WINNING_STATISTIC_STRING = "당첨 통계\n---";
    private final static String THREE_SAME_NUMBER = "3개 일치 (5,000원) - ";
    private final static String FOUR_SAME_NUMBER = "4개 일치 (50,000원) - ";
    private final static String FIVE_SAME_NUMBER = "5개 일치 (1,500,000원) - ";
    private final static String FIVE_SAME_NUMBER_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final static String LOTTO_WIN = "6개 일치 (2,000,000,000원) - ";
    private final static String COUNT_STRING = "개";
    private final static String GROSS_RETURN = "총 수익률은 ";
    private final static String GROSS_RETURN_END_STRING = "%입니다.";

    public void printLottoCount(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + LOTTO_COUNT_STRING);
        printLottoNumbers(lottoCount, lottos);
    }

    public void printLottoNumbers(int lottoCount, List<Lotto> lottos) {
        for (int i = 0; i < lottoCount; i++) {
            Lotto userLotto = lottos.get(i);
            printLottoNumber(userLotto);
        }
    }

    public void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printWinningStatistic(List<Integer> winningCounts, int grossProfitPercentage) {
        System.out.println(WINNING_STATISTIC_STRING);
        System.out.println(THREE_SAME_NUMBER + winningCounts.get(0) + COUNT_STRING);
        System.out.println(FOUR_SAME_NUMBER + winningCounts.get(1) + COUNT_STRING);
        System.out.println(FIVE_SAME_NUMBER + winningCounts.get(2) + COUNT_STRING);
        System.out.println(FIVE_SAME_NUMBER_BONUS + winningCounts.get(3) + COUNT_STRING);
        System.out.println(LOTTO_WIN + winningCounts.get(4) + COUNT_STRING);
        System.out.println(GROSS_RETURN + grossProfitPercentage + GROSS_RETURN_END_STRING);
    }
}
