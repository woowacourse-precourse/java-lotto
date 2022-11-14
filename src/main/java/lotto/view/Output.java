package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseMoney;
import lotto.domain.WinningList;
import lotto.enumeration.Ranking;

import java.text.NumberFormat;
import java.util.Map;

import static lotto.domain.LottoMachine.caculateRateOfProfit;
import static lotto.enumeration.Ranking.*;

public class Output {

    private static final String STATS_GUIDE = "당첨 통계\n" + "---";
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }

    public static void printLottos(Lottos lottos) {
        printLottosCount(lottos.getLottosCount());
        printLottosInfo(lottos);
    }

    public static void printWinningList(WinningList winningList) {
        printStatsGuide();
        printStats(winningList);
    }

    public static void printRateofProfit(WinningList winningList, PurchaseMoney purchaseMoney) {
        Double rateOfProfit = caculateRateOfProfit(winningList, purchaseMoney);
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfProfit);
    }

    private static void printStats(WinningList winningList) {
        String FIFTH_STATS = String.format("3개 일치 (%s원) - %s개", numberFormat.format(FIFTH.getPrizeMoney()), winningList.getWinningInfo().getOrDefault(FIFTH, 0));
        String FORTH_STATS = String.format("4개 일치 (%s원) - %s개", numberFormat.format(FORTH.getPrizeMoney()), winningList.getWinningInfo().getOrDefault(FORTH, 0));
        String THIRD_STATS = String.format("5개 일치 (%s원) - %s개", numberFormat.format(THIRD.getPrizeMoney()), winningList.getWinningInfo().getOrDefault(THIRD, 0));
        String SECOND_STATS = String.format("5개 일치, 보너스 볼 일치 (%s원) - %s개", numberFormat.format(SECOND.getPrizeMoney()), winningList.getWinningInfo().getOrDefault(SECOND, 0));
        String FIRST_STATS = String.format("6개 일치 (%s원) - %s개", numberFormat.format(FIRST.getPrizeMoney()), winningList.getWinningInfo().getOrDefault(FIRST, 0));
        System.out.println(FIFTH_STATS);
        System.out.println(FORTH_STATS);
        System.out.println(THIRD_STATS);
        System.out.println(SECOND_STATS);
        System.out.println(FIRST_STATS);
    }

    private static void printStatsGuide() {
        System.out.println(STATS_GUIDE);
    }

    public static void printLottosCount(int lottosCount) {
        System.out.println(lottosCount + "개를 구매했습니다.");
    }

    public static void printLottosInfo(Lottos lottos) {
        lottos.getLottos()
                .stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);

    }
}
