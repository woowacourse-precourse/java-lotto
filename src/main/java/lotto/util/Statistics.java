package lotto.util;

import lotto.domain.WinningTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    public static Map<WinningTable, Integer> winningTableListToMap(List<WinningTable> winningInfo) {
        Map<WinningTable, Integer> map = new HashMap<>();

        for (WinningTable winningTable : WinningTable.values()) {
            map.put(winningTable, matchCount(winningInfo, winningTable));
        }
        return map;
    }

    public static List<Integer> calWinningPricesFromWinningInfo(List<WinningTable> winningInfo) {
        List<Integer> winningPrices = new ArrayList<>();
        for (WinningTable winningTable : winningInfo) {
            winningPrices.add(winningTable.getPrice());
        }

        return winningPrices;

    }

    private static int matchCount(List<WinningTable> winningInfo, WinningTable winningTable) {
        return (int) winningInfo
                .stream()
                .filter(element -> element == winningTable)
                .count();
    }
}
