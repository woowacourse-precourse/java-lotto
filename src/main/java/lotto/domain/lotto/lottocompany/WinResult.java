package lotto.domain.lotto.lottocompany;

import static lotto.domain.lotto.lottocompany.Win.*;

import java.util.HashMap;
import java.util.Map;

public class WinResult {

    private final Map<Win, Integer> winResult;

    public WinResult() {
        this.winResult = new HashMap<>();
        this.winResult.put(first, 0);
        this.winResult.put(second, 0);
        this.winResult.put(third, 0);
        this.winResult.put(fourth, 0);
        this.winResult.put(fifth, 0);
    }

    public Map<Win, Integer> getWinResult() {
        return winResult;
    }

    public void addWin(Win win) {
        winResult.replace(win, winResult.get(win) + 1);
    }
}
