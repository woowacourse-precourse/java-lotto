package lotto.utils.iosupport;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.utils.constants.Comment;
import lotto.utils.constants.IntegerCommon;
import lotto.utils.constants.Winning;

public class LottoPrinter {

    public static void printPurchaseAmount(long purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount + Comment.OUTPUT_AMOUNT.getComment());
    }

    public static void printLottoLists(List<Lotto> lottoNumbers) {
        IntStream.range(IntegerCommon.ZERO.getNumber(), lottoNumbers.size())
                .forEach((index) -> System.out.println((lottoNumbers.get(index).getNumbers())));
    }

    public static void printWinningStats(Map<Integer, Long> winningStats, double returnRate) {
        System.out.println(Comment.WINNING_STATS);
        System.out.println("---");

        for (int index = IntegerCommon.ZERO.getNumber(); index < Winning.values().length; index++) {
            Winning winning = Winning.values()[index];
            System.out.println(getWinningStatsMessage(
                    winning, winningStats.getOrDefault(
                            index + IntegerCommon.COUNT.getNumber(),
                            (long) IntegerCommon.ZERO.getNumber())));
        }
        System.out.println("총 수익률은 " + String.format("%.1f", returnRate) + "%입니다.");
    }

    public static String getWinningStatsMessage(Winning winning, long winningCount) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        if (winning == Winning.SECOND_PLACE) {
            return winning.getMatchAmount() + "개 일치, 보너스 볼 일치 ("
                    + formatter.format(winning.getMoney()) + "원) - " + winningCount + "개";
        }
        return winning.getMatchAmount() + "개 일치 ("
                + formatter.format(winning.getMoney()) + "원) - " + winningCount + "개";
    }
}
