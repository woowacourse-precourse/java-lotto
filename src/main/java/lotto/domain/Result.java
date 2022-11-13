package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private int totalPrize = 0;
    private Map<String, Integer> winResult = new HashMap<>();

    public Result(Lotto winLotto, int bonusNum, List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            Grade grade = checkLotto(winLotto, bonusNum, lotto);

            this.totalPrize += grade.getPrize();
            int value = winResult.getOrDefault(grade.getName(), 0);
            this.winResult.put(grade.getName(), value + 1);
        }
    }

    private Grade checkLotto(Lotto winLotto, int bonusNum, Lotto lotto) {
        int sameNumCount = winLotto.getSameNumCount(lotto.getNumbers());
        boolean isBonusSame = lotto.checkBonus(bonusNum);
        return Grade.valueOf(sameNumCount, isBonusSame);
    }

    public int getTotalPrize() {
        return this.totalPrize;
    }

    public Map<String, Integer> getWinResult() {
        return this.winResult;
    }
}
