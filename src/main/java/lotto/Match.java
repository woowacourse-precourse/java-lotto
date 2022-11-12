package lotto;

import java.util.*;

public class Match {
    private static final Integer SIX = 6;
    private static final Integer FIVE = 5;
    private static final Integer FOUR = 4;
    private static final Integer THREE = 3;

    private final Map<Lanking, Integer> matches;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public Match(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<Lanking, Integer> map = new HashMap<>();
        map.put(Lanking.rank1, 0);
        map.put(Lanking.rank2, 0);
        map.put(Lanking.rank3, 0);
        map.put(Lanking.rank4, 0);
        map.put(Lanking.rank5, 0);
        this.matches = map;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void matchNumbers(List<Lotto> lottos) {
        // 5-1. 당첨 번호와 몇 개가 일치하는지 갯수를 구한다.
        for (Lotto lotto : lottos) {
            List<Integer> combineNumbers = new ArrayList<>(lotto.getNumbers());
            combineNumbers.addAll(this.winningNumbers.getNumbers());
            Integer matchNum = combineNumbers.size() - new HashSet<>(combineNumbers).size(); // 12 -
            lank(matchNum);
        }
    }

    private void lank(Integer matchNum) {
        // 5-2. 등수 별로 몇 개가 있는지 갯수를 구한다.
        if (matchNum.equals(SIX)) this.matches.put(Lanking.rank1, this.matches.get(Lanking.rank1)+1);
        else if (matchNum.equals(FIVE)) {
            if (this.winningNumbers.getNumbers().contains(this.bonusNumber.getNumber()))
                this.matches.put(Lanking.rank2, this.matches.get(Lanking.rank2)+1);
            else this.matches.put(Lanking.rank3, this.matches.get(Lanking.rank3)+1);
        }
        else if (matchNum.equals(FOUR)) this.matches.put(Lanking.rank4, this.matches.get(Lanking.rank4)+1);
        else if (matchNum.equals(THREE)) this.matches.put(Lanking.rank5, this.matches.get(Lanking.rank5)+1);

    }

    public Map<Lanking, Integer> getMatches() {
        return this.matches;
    }
}
