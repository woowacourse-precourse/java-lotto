package lotto.view;

import lotto.model.Lottos;
import lotto.model.Prize;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Consumer;

import static java.util.Comparator.comparingInt;

public class OutputView {

    public static final String WINNING_ANALYSIS = "당첨 통계";
    public static final String LINE = "---";

    public static void printLottosHistory(Lottos lottos) {
        printNewLine();
        lottos.printAll();
    }

    public static void printResultMessage(Map<Prize, Long> winningResults) {
        printNewLine();
        System.out.println(WINNING_ANALYSIS);
        System.out.println(LINE);
        printWinningResults(winningResults);
    }

    private static void printWinningResults(Map<Prize, Long> winningResults) {
        winningResults.entrySet().stream()
                .sorted(sortByMoneyAsc())
                .forEach(printWinningAnalysis());
    }

    private static Comparator<Map.Entry<Prize, Long>> sortByMoneyAsc() {
        return comparingInt(OutputView::moneyAsc);
    }

    private static int moneyAsc(Map.Entry<Prize, Long> winningResult) {
        return winningResult.getKey().getMoney();
    }

    private static Consumer<Map.Entry<Prize, Long>> printWinningAnalysis() {
        return OutputView::makeAnalysis;
    }

    private static void makeAnalysis(Map.Entry<Prize, Long> winningResult) {
        winningResult.getKey().printMessageWithCount(winningResult.getValue());
    }

    private static void printNewLine() {
        System.out.println();
    }

    public static void printEarningRates(Double earningRates) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", earningRates));
    }
}
