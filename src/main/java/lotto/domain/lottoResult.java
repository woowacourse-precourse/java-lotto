package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class lottoResult {
    public List<Integer> winResult = new ArrayList<>();

    public lottoResult(List<List<Integer>> groupLotto, List<Integer> winLotto, int bonusNum) {
        for (int i=0; i<5; i++) {
            winResult.add(0);
        }
        for (List<Integer> lotto : groupLotto) {
            int match = calLotto(lotto, winLotto);
            boolean sameBonus = matchBonus(lotto,bonusNum);
            addRank(match, sameBonus);
        }
    }

    public int calLotto(List<Integer> myLotto, List<Integer> winLotto) {
        int count = 0;
        for (int num : myLotto) {
            if(winLotto.contains(num)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean matchBonus(List<Integer> myLotto, int bonusNum) {
        return myLotto.contains(bonusNum);
    }

    public void addRank(int match, boolean sameBonus) {
        if (match == 3) {
            winResult.set(0, winResult.get(0) + 1);
        }
        if (match == 4) {
            winResult.set(1, winResult.get(1) + 1);
        }
        if ((match == 5) && (!sameBonus)) {
            winResult.set(2, winResult.get(2) + 1);
        }
        if ((match == 5) && (sameBonus)) {
            winResult.set(3, winResult.get(3) + 1);
        }
        if (match == 6) {
            winResult.set(4, winResult.get(4) + 1);
        }
    }

    public List<Integer> getWinResult() {
        return winResult;
    }
}
