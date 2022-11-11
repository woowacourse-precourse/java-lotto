package lotto;

import java.util.List;
import java.util.Map;

public class LottoWin {

    public LottoWin(List<List<Integer>> quickPicks, List<Integer> lotto, int bonus) {
        if(lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }
        if(bonus < LottoState.START.number() || bonus > LottoState.END.number()){
            throw new IllegalArgumentException();
        }
    }
    public Map<String,Integer> getPrizesMap() {
        return Map.of("1st", 1);
    }
}
