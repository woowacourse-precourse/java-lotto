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

    private static int matchCount(List<WinningTable> winningInfo, WinningTable winningTable) {
        return (int) winningInfo
                .stream()
                .filter(element -> element == winningTable)
                .count();
    }

    public static List<Integer> calWinningPricesFromWinningInfo(List<WinningTable> winningInfo) {
        List<Integer> winningPrices = new ArrayList<>();
        for (WinningTable winningTable : winningInfo) {
            winningPrices.add(winningTable.getPrice());
        }

        return winningPrices;
    }

    public static int sum(List<Integer> list) {
        return list
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static double calProfitRate(int original, int profit) {
        return (double) profit / original * 100;
    }
}
