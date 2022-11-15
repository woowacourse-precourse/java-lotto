package lotto.console;

import lotto.domain.WinningTable;

import java.util.Map;

import static lotto.constants.ConsoleMessages.*;

public class StatisticsConsole {
    public void print(Map<WinningTable, Integer> map, double profitRate) {
        System.out.println(STATISTICS);
        System.out.printf(FIFTH, map.get(WinningTable.FIFTH));
        System.out.printf(FORTH, map.get(WinningTable.FORTH));
        System.out.printf(THIRD, map.get(WinningTable.THIRD));
        System.out.printf(SECOND, map.get(WinningTable.SECOND));
        System.out.printf(FIRST, map.get(WinningTable.FIRST));
        System.out.printf(PROFIT, profitRate);
    }
}
