package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoPurchaseMoney;
import lotto.domain.Rank;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private static final String LOTTO_SIZE_OUTPUT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_SUFFIX = "]";
    private static final String SEPARATOR = ", ";

    private static final String LOTTO_GAME_RESULT_START_MESSAGE = "당첨 통계\n---";

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + errorMessage);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        printLottoSize(lottos.size());
        lottos.forEach(OutputView::printLotto);
    }

    private static void printLottoSize(int size) {
        System.out.print(size);
        System.out.println(LOTTO_SIZE_OUTPUT_MESSAGE);
    }

    private static void printLotto(Lotto lotto) {
        StringBuilder lottoMessage = new StringBuilder(LOTTO_PREFIX);
        for (int number : lotto.getNumbers()) {
            lottoMessage.append(number).append(SEPARATOR);
        }
        lottoMessage = new StringBuilder(lottoMessage.substring(0, lottoMessage.length() - 2));
        lottoMessage.append(LOTTO_SUFFIX);
        System.out.println(lottoMessage);
    }

    public static void printTotalResult(LottoGameResult lottoGameResult, LottoPurchaseMoney lottoPurchaseMoney) {
        System.out.println();
        System.out.println(LOTTO_GAME_RESULT_START_MESSAGE);

        Map<Rank, Integer> winningResult = lottoGameResult.getWinningResult();
        int money = lottoPurchaseMoney.getMoney();

        printWinningResult(winningResult);
        printProfitLate(winningResult, money);
    }

    private static void printWinningResult(Map<Rank, Integer> winningResult) {
        DecimalFormat df = new DecimalFormat("###,###");
        
        System.out.println(Rank.FIFTH.getCount()+ "개 일치 (" + df.format(Rank.FIFTH.getReward()) + "원) - " + winningResult.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println(Rank.FOURTH.getCount()+ "개 일치 (" + df.format(Rank.FOURTH.getReward()) + "원) - " + winningResult.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println(Rank.THIRD.getCount()+ "개 일치 (" + df.format(Rank.THIRD.getReward()) + "원) - " + winningResult.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println(Rank.SECOND.getCount()+ "개 일치, 보너스 볼 일치 (" + df.format(Rank.SECOND.getReward()) + "원) - " + winningResult.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println(Rank.FIRST.getCount()+ "개 일치 (" + df.format(Rank.FIRST.getReward()) + "원) - " + winningResult.getOrDefault(Rank.FIRST, 0) + "개");
    }

    private static void printProfitLate(Map<Rank, Integer> winningResult, int money) {
        int profit = 0;
        for (Rank rank : winningResult.keySet()) {
            profit += rank.getReward() * winningResult.get(rank);
        }

        double profitRate = (double)profit / money * 100;

        System.out.print("총 수익률은 ");
        System.out.print(String.format("%.1f", profitRate));
        System.out.print("%입니다.");
    }
}
