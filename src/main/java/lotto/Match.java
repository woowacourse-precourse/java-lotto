package lotto;

import java.util.*;

public class Match {
    private final Map<String, Integer> matches;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public Match(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Map<String, Integer> map = new HashMap<>();
        map.put("1등", 0);
        map.put("2등", 0);
        map.put("3등", 0);
        map.put("4등", 0);
        map.put("5등", 0);
        this.matches = map;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void matchNumbers(List<Lotto> lottos) {
        // 5-1. 당첨 번호와 몇 개가 일치하는지 갯수를 구한다.
        for (Lotto lotto : lottos) {
            List<Integer> combineNumbers = new ArrayList<>(lotto.getNumbers());
            combineNumbers.addAll(this.winningNumbers.getNumbers());
            Integer matchNum = 12 - new HashSet<>(combineNumbers).size();
            lank(matchNum);
        }
    }

    private void lank(Integer matchNum) {
        // 5-2. 등수 별로 몇 개가 있는지 갯수를 구한다.
        if (matchNum == 6) this.matches.put("1등", this.matches.get("1등")+1);
        else if (matchNum == 5) {
            if (this.winningNumbers.getNumbers().contains(this.bonusNumber.getNumber()))
                this.matches.put("2등", this.matches.get("3등")+1);
            else this.matches.put("3등", this.matches.get("3등")+1);
        }
        else if (matchNum == 4) this.matches.put("4등", this.matches.get("4등")+1);
        else if (matchNum == 3) this.matches.put("5등", this.matches.get("5등")+1);

    }

    public Map<String, Integer> getMatches() {
        return this.matches;
    }
}
