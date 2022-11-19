package lotto.view;

import lotto.constants.WinningMessage;
import lotto.domain.Lotto;
import lotto.domain.WinningTable;

import java.util.List;
import java.util.Map;

import static lotto.constants.ConsoleMessages.*;

public class OutputView {

    public void printInputPrice() {
        System.out.println(INPUT_PRICE);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinningInput() {
        System.out.println(INPUT_NUMBERS);
    }

    public void printBonusInput() {
        System.out.println(INPUT_BONUS);
    }

    public void printStatistics(Map<WinningTable, Integer> map, double profitRate) {
        System.out.println(STATISTICS);
        System.out.printf(WinningMessage.FIFTH.getMessage(), map.get(WinningTable.FIFTH));
        System.out.printf(WinningMessage.FORTH.getMessage(), map.get(WinningTable.FORTH));
        System.out.printf(WinningMessage.THIRD.getMessage(), map.get(WinningTable.THIRD));
        System.out.printf(WinningMessage.SECOND.getMessage(), map.get(WinningTable.SECOND));
        System.out.printf(WinningMessage.FIRST.getMessage(), map.get(WinningTable.FIRST));
        System.out.printf(PROFIT, profitRate);
    }

    public void printException(String message) {
        System.out.println(message);
    }
}
