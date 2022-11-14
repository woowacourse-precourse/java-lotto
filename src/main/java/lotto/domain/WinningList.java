package lotto.domain;

import lotto.enumeration.Ranking;

import java.util.Map;

public class WinningList {

    private final Map<Ranking, Integer> winningInfo;

    public WinningList(Map<Ranking, Integer> winningInfo) {
        this.winningInfo = winningInfo;
    }

    public Map<Ranking, Integer> getWinningInfo() {
        return this.winningInfo;
    }
}
