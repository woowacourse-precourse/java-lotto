package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final Map<WinningTable, Integer> map;
    private final List<WinningTable> list;

    public Map<WinningTable, Integer> getMap() {
        return map;
    }

    public List<WinningTable> getList() {
        return list;
    }

    public WinningResult(List<Lotto> lottos, WinningLotto winningLotto) {
        list = calWinningInfo(lottos, winningLotto);
        map = setMapFromwinningTables();
    }

    private Map<WinningTable, Integer> setMapFromwinningTables() {
        Map<WinningTable, Integer> map = new HashMap<>();

        for (WinningTable winningTable : WinningTable.values()) {
            int count = (int) list
                    .stream()
                    .filter(a -> a == winningTable)
                    .count();
            map.put(winningTable, count);
        }
        return map;
    }

    private List<WinningTable> calWinningInfo(List<Lotto> lottos, WinningLotto winningLotto) {
        Winning winning = new Winning();
        List<WinningTable> list = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinningTable wt = winning.calMyScore(lotto, winningLotto);
            list.add(wt);
        }
        return list;
    }
}
