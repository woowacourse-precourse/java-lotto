package lotto.domain;

import java.util.List;

public class Judgement {

    public int sameNumberCount(List<Integer> myLotto, List<Integer> winLotto) {
        int count = 0;
        for (int index = 0; index < winLotto.size(); index++) {
            if (myLotto.contains(winLotto.get(index))) {
                count++;
            }
        }
        return count;
    }

    public boolean containBonusNumber(List<Integer> myLotto, int bounusNumber) {
        return myLotto.contains(bounusNumber);
    }
}
