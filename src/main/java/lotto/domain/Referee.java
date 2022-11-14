package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Referee {
    private List<Lotto> lottoList;
    private List<Integer> winNumbers;
    private int bonusNumber;

    public Referee(List<Lotto> lottoList, List<Integer> winNumbers, int bonusNumber) {
        this.lottoList = lottoList;
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Result compare() {
        Statistics statistics = new Statistics();
        Judgment judgment = new Judgment(winNumbers, bonusNumber);
        for (Lotto lotto : lottoList) {
            statistics.record(judgment.countCorrect(lotto), judgment.checkBonus(lotto));
        }
        return new Result(statistics.getMap(), statistics.getYield(lottoList.size()));
    }
}

