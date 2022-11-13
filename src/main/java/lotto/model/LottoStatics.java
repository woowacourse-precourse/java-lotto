package lotto.model;

import java.util.HashMap;

public class LottoStatics {
    private static final int DEFAULT_WINNING = 0;
    private HashMap<Winning, Integer> staticsInfo;

    public LottoStatics() {
        initialMap();
    }

    private void initialMap() {
        HashMap<Winning, Integer> staticsInfo = new HashMap<>();
        for (Winning value : Winning.values()) {
            staticsInfo.put(value, DEFAULT_WINNING);
        }
        this.staticsInfo = staticsInfo;
    }
}
