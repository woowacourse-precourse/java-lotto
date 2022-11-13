package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private Map<Winning, Integer> winningResultMap;

    public WinningResult(Map<Winning, Integer> winningResultMap) {
        this.winningResultMap = winningResultMap;
    }

    public Map<Winning, Integer> getWinningResultMap() {
        return winningResultMap;
    }
}
