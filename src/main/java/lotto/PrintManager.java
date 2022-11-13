package lotto;

import java.util.List;

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

    public void printWinningStatus() {
        printWinningList();
        printYield();
    }

    private void printWinningList() {

    }

    private void printYield() {

    }
}
