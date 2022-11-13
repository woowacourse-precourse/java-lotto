package lotto;

import java.util.List;
import java.util.Map;

public class PrintManager {
    public void printRequestPrice() {
        System.out.println(ConsoleMessage.REQUEST_PURCHASE);
    }

    public void printRequestWinningNumber() {
        System.out.println(ConsoleMessage.REQUEST_WINNING_NUMBERS);
    }

    public void printRequestBonusNumber() {
        System.out.println(ConsoleMessage.REQUEST_BONUS_NUMBER);
    }

    public void printLottoList(List<Lotto>lottos) {
        System.out.printf(String.valueOf(ConsoleMessage.RESPONSE_PURCHASE), lottos.size());
        System.out.print(ConsoleMessage.NEW_LINE);
        lottos.forEach(System.out::println);
        System.out.print(ConsoleMessage.NEW_LINE);
    }

    public void printWinningStatus(Map<LottoGrade, Integer> analyze, double yield) {
        analyze.remove(LottoGrade.BANG);
        printWinningList(analyze);
        printYield(yield);
    }

    private void printWinningList(Map<LottoGrade, Integer> analyze) {
        analyze.forEach((key, value) -> {
            System.out.printf(String.valueOf(ConsoleMessage.STATISTICS_ELEMENT_FORMAT), key, value);
            System.out.print(ConsoleMessage.NEW_LINE);
        });
    }

    private void printYield(double yield) {
        System.out.printf(String.valueOf(ConsoleMessage.RESPONSE_YIELD),
                Math.round(yield*100)/100.0);
    }
}
