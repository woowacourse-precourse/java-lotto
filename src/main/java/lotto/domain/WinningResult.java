package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<WinningTable, Integer> map;
    private final List<Integer> winningPrices;

    public Map<WinningTable, Integer> getMap() {
        return map;
    }

    public List<Integer> getWinningPrices() {
        return winningPrices;
    }

    public WinningResult(List<Lotto> lottos, WinningLotto winningLotto) {
        List<WinningTable> winningInfo = calWinningInfo(lottos, winningLotto);
        winningPrices = calWinningPrices(winningInfo);
        map = setMapFromwinningTables(winningInfo);
    }

    private List<Integer> calWinningPrices(List<WinningTable> winningInfo) {
        List<Integer> list = new ArrayList<>();
        for (WinningTable wt : winningInfo) {
            list.add(wt.getPrice());
        }

        return list;
    }

    private Map<WinningTable, Integer> setMapFromwinningTables(List<WinningTable> winningInfo) {
        Map<WinningTable, Integer> map = new HashMap<>();

        for (WinningTable winningTable : WinningTable.values()) {
            int count = (int) winningInfo
                    .stream()
                    .filter(element -> element == winningTable)
                    .count();
            map.put(winningTable, count);
        }
        return map;
    }

    private List<WinningTable> calWinningInfo(List<Lotto> lottos, WinningLotto winningLotto) {
        Winning winning = new Winning();
        List<WinningTable> winningInfo = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinningTable wt = winning.calMyScore(lotto, winningLotto);
            winningInfo.add(wt);
        }
        return winningInfo;
    }
}
