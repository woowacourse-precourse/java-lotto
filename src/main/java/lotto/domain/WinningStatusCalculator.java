package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WinningStatusCalculator {

    //TreeMap 으로 선언해야 합니다
    Map<Rank, Integer> winningStatus = new TreeMap<>();

    public Map<Rank, Integer> createWinningStatus(List<Lotto> lottos, WinningNumbers winningNumbers) {

        initWinningStaus();

        for (Lotto lotto : lottos) {
            Rank rank = Rank.calculateRank(lotto, winningNumbers);
            winningStatus.put(rank, winningStatus.get(rank) + 1);
        }

        return winningStatus;
    }

    private void initWinningStaus(){
        for (Rank rank : Rank.values()) {
            winningStatus.put(rank, 0);
        }
    }

}
