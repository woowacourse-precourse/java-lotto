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
        }
    }

    public Map<Integer, Integer> getMatches() {
        return this.matches;
    }
}
