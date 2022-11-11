package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    List<List<Integer>> purchasedLotteries;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>() {
        {
            put("fifth", 0);
            put("fourth", 0);
            put("third", 0);
            put("second", 0);
            put("first", 0);
        }
    };

    public Result(List<List<Integer>> purchasedLotteries,
                  WinningNumbers winningNumbers,
                  BonusNumber bonusNumber) {
        this.purchasedLotteries = purchasedLotteries;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }

    // TODO : 리팩토링 인덴트 1 유지 & 하드코딩 삭제
    public void countWinningCase() {
        for (List<Integer> purchasedLotto : purchasedLotteries) {
            int winningCount = winningNumbers.countWinning(purchasedLotto);

            if (winningCount == 6) {
                resultMap.put("first", resultMap.get("first") + 1);
            }
            if (winningCount == 5) {
                if (bonusNumber.checkContainBonusNumber(purchasedLotto)) {
                    resultMap.put("second", resultMap.get("second") + 1);
                }

                if (bonusNumber.checkContainBonusNumber(purchasedLotto)) {
                    resultMap.put("third", resultMap.get("third") + 1);
                }
            }
            if (winningCount == 4) {
                resultMap.put("fourth", resultMap.get("fourth") + 1);
            }
            if (winningCount == 3) {
                resultMap.put("fifth", resultMap.get("fifth") + 1);
            }


        }
    }
}
