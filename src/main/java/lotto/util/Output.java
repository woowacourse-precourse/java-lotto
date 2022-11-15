package lotto.util;

import lotto.domain.Result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Output {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static void printInputMessage() {
        System.out.println(INPUT_MONEY);
    }

    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    public static void printBuyMessage(int number) {
        System.out.println("\n" + number + BUY_MESSAGE);
    }

    public static void printLotto(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]"))
        );
    }

    private static final String INPUT_WINNINGS = "\n당첨 번호를 입력해 주세요.";
    public static void printInputWinnings() {
        System.out.println(INPUT_WINNINGS);
    }

    private static final String INPUT_BONUS = "\n보너스 번호를 입력해 주세요.";
    public static void printInputBonus() {
        System.out.println(INPUT_BONUS);
    }

    private static final String STATISTICS = "\n당첨 통계\n---";
    public static void printStatistics(Map<Result, Integer> resultCounts) {
        System.out.println(STATISTICS);
        for (Map.Entry<Result, Integer> resultCount : resultCounts.entrySet()) {
            Result result = resultCount.getKey();
            int count = resultCount.getValue();
            System.out.println(result.getMessage() + " (" + result.getMoney() + "원)" + " - " + count + "개");
        }
    }

    public static void printYield(double yield) {
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }

    public static void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
