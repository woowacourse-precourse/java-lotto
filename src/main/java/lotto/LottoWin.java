package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoWin {
    int count;

    public LottoWin(List<List<Integer>> quickPicks, List<Integer> lotto, int bonus) {
        count = 0;
        if(lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }
        if(bonus < LottoState.START.number() || bonus > LottoState.END.number()){
            throw new IllegalArgumentException();
        }
        for(List<Integer> quickPick: quickPicks) {
            ArrayList<Integer> tmpArr = new ArrayList<>(quickPick);
            tmpArr.retainAll(lotto);
            if (tmpArr.size() == LottoState.LENGTH.number()) {
                count++;
            }
        }
    }
    public Map<String,Integer> getPrizesMap() {
        return Map.of("1st", count);
    }
}
