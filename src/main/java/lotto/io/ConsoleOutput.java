package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.ProfitCalculator;
import lotto.domain.Result;
import lotto.domain.WinningPrice;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.IntStream;

public class ConsoleOutput {
    public static final int PURCHASE_AMOUNT = 1;
    public static final int WINNING_NUMBER = 2;
    public static final int BONUS_NUMBER = 3;
    private static DecimalFormat formatter = new DecimalFormat("###,###");

    public static void printGuide(int guideNumber) {
        if (guideNumber == PURCHASE_AMOUNT)
            System.out.println("구입금액을 입력해 주세요.");
        else if (guideNumber == WINNING_NUMBER)
            System.out.println("당첨 번호를 입력해 주세요.");
        else if (guideNumber == BONUS_NUMBER)
            System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printNumOfLotto(int numOfLotto) {
        System.out.println(numOfLotto + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto.getNumbers());
        }
    }

    private static void printLottoNumber(List<Integer> numbers) {
        System.out.print("[");
        IntStream.range(0, numbers.size())
                .forEach(index -> {
                    System.out.print(numbers.get(index));
                    if (index != numbers.size() - 1)
                        System.out.print(", ");
                });
        System.out.println("]");
    }

    public static void printWinningStatistics(List<Result> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (WinningPrice winningPrice : WinningPrice.values()) {
            printWinningPrice(winningPrice);
            System.out.println(winningPrice.countMatchResult(results) + "개");
        }
        System.out.printf("총 수익률은 %.1f%입니다.\n", ProfitCalculator.getProfit(results));
    }

    private static void printWinningPrice(WinningPrice winningPrice) {
        System.out.print(winningPrice.getAccordedNumber() + "개 일치 ");
        if (winningPrice.shouldHitBonus()) {
            System.out.println(", 보너스 볼 일치 ");
        }
        System.out.print("(" + formatter.format(winningPrice.getPrice()) + ") - ");
    }
}
