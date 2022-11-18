package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    List<Integer> winningNumbers;
    int bonus;

    public WinningResult(List<Integer> winningNumbers, int bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public List<Integer> getWinningPrices(List<Lotto> lottos) {
        List<WinningTable> winningInfo = calWinningInfo(lottos);
        List<Integer> list = new ArrayList<>();
        for (WinningTable winningTable : winningInfo) {
            list.add(winningTable.getPrice());
        }

        return list;
    }

    public Map<WinningTable, Integer> getMap(List<Lotto> lottos) {
        List<WinningTable> winningInfo = calWinningInfo(lottos);
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

    private List<WinningTable> calWinningInfo(List<Lotto> lottos) {
        Winning winning = new Winning(winningNumbers, bonus);
        List<WinningTable> winningInfo = new ArrayList<>();
        for (Lotto lotto : lottos) {
            WinningTable wt = winning.calMyScore(lotto);
            winningInfo.add(wt);
        }
        return winningInfo;
    }
}
