package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private int totalPrize = 0;
    private Map<String, Integer> winResult = new HashMap<>()  {
        {
            put("5등", 0);
            put("4등", 0);
            put("3등", 0);
            put("2등", 0);
            put("1등", 0);
        }
    };

    public Result(WinLotto winLotto, int bonusNum, List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            Grade grade = checkLotto(winLotto, bonusNum, lotto);

            this.totalPrize += grade.getPrize();
            int value = winResult.getOrDefault(grade.getName(), 0);
            this.winResult.put(grade.getName(), value + 1);
        }
    }

    private Grade checkLotto(WinLotto winLotto, int bonusNum, Lotto lotto) {
        int sameNumCount = winLotto.get().getSameNumCount(lotto.getNumbers());
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
