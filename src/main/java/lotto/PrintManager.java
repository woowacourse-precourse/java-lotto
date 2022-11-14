package lotto;

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

    public void printLottoList(Lottos lottos) {
        System.out.printf(String.valueOf(ConsoleMessage.RESPONSE_PURCHASE), lottos.size());
        System.out.print(ConsoleMessage.NEW_LINE);
        lottos.forEach(System.out::println);
        System.out.print(ConsoleMessage.NEW_LINE);
    }

    public void printWinningStatus(LottoGradeCounter analyze, double yield) {
        printWinningList(analyze.getPrintList());
        printYield(yield);
    }

    private void printWinningList(LottoGradeCounter analyze) {
        analyze.forEach((key, value) -> {
            System.out.printf(String.valueOf(ConsoleMessage.STATISTICS_ELEMENT_FORMAT), key, value);
            System.out.print(ConsoleMessage.NEW_LINE);
        });
    }

    private void printYield(double yield) {
        System.out.printf(String.valueOf(ConsoleMessage.RESPONSE_YIELD), yield);
    }
}
