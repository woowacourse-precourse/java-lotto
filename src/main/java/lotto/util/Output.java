package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

public class Output {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNINGS = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "\n보너스 번호를 입력해 주세요.";
    private static final String STATISTICS = "\n당첨 통계\n---";
    private static final NumberFormat numberFormat = new DecimalFormat("###,###.0");

    private Output() {}

    public static void printInputMessage() {
        System.out.println(INPUT_MONEY);
    }

    public static void printBuyMessage(int number) {
        System.out.println("\n" + number + BUY_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.makeString());
        }
    }

    public static void printInputWinnings() {
        System.out.println(INPUT_WINNINGS);
    }

    public static void printInputBonus() {
        System.out.println(INPUT_BONUS);
    }

    public static void printStatistics(Map<Result, Integer> resultCounts) {
        System.out.println(STATISTICS);
        for (Map.Entry<Result, Integer> resultCount : resultCounts.entrySet()) {
            Result result = resultCount.getKey();
            int count = resultCount.getValue();
            System.out.println(result.getMessage() + " (" + result.getMoney() + "원)" + " - " + count + "개");
        }
    }

    public static void printYield(double yield) {
        System.out.println("총 수익률은 " + numberFormat.format(yield) + "%입니다.");
    }

    public static void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
