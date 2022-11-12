package lotto;

import java.util.*;

public class Match {
    private final Map<Integer, Integer> matches;

    public Match() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        this.matches = map;
    }

    public void matchNumbers(List<Lotto> lottos, PickLotto pickLotto, BonusNum bonusNum) {
        // 5-1. 당첨 번호와 몇 개가 일치하는지 갯수를 구한다.
        for (Lotto lotto : lottos) {
            List<Integer> combineNumbers = new ArrayList<>(lotto.getNumbers());
            combineNumbers.addAll(pickLotto.getNumbers());
            combineNumbers.add(bonusNum.getNumber());
            int matchNum = 13 - new HashSet<>(combineNumbers).size();
            // 5-2. 등수 별로 몇 개가 있는지 갯수를 구한다.
            if (3 <= matchNum && matchNum <= 6) {
                this.matches.put(matchNum, this.matches.get(matchNum)+1);
            }
        }
    }

    public Map<Integer, Integer> getMatches() {
        return this.matches;
    }
}
