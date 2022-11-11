package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    List<List<Integer>> purchasedLotteries;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    Map<String, Integer> resultMap = new HashMap<String, Integer>() {
        {
            put("first", 0);
            put("second", 0);
            put("third", 0);
            put("fourth", 0);
            put("fifth", 0);
            put("sixth", 0);
        }
    };

    public Result(List<List<Integer>> purchasedLotteries,
                       WinningNumbers winningNumbers,
                       BonusNumber bonusNumber) {
        this.purchasedLotteries = purchasedLotteries;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void countWinningCase() {
    }
}
