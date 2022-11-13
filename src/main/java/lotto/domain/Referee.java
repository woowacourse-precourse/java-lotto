package lotto.domain;

import java.util.Arrays;
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
        Map map = new HashMap<>();
        Statistics statistics = new Statistics();
        Judgment judgment = new Judgment(winNumbers, bonusNumber);
        for (Lotto lotto : lottoList) {
            statistics.record(judgment.countCorrect(lotto), judgment.checkBonus(lotto) );
        }
        return new Result(statistics.getMap(), statistics.getYield());
    }
}

class Judgment {
    List<Integer> winNumbers;
    int bonusNum;

    Judgment(List<Integer> winNumbers, int bonusNum) {
        this.winNumbers = winNumbers;
        this.bonusNum = bonusNum;
    }

    int countCorrect(Lotto lotto) {
        int result = 0;
        for (int num : lotto.getNumbers()) {
            if (winNumbers.contains(num)) {
                result++;
            }
        }
        return result;
    }

    boolean checkBonus(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNum)) {
            return true;
        }
        return false;
    }
}

class Statistics {
    Map map;

    Statistics() {
        map = new HashMap<Double, Integer>();
        double[] correctNums = {3, 4, 5, 5.5, 6};
        for (double num : correctNums) {
            map.put(num, 0);
        }
    }

    void record(int correctNum, boolean bonus) {
        if (correctNum < 3) {
            return;
        }
        if (correctNum == 5 && bonus) {
            correctNum += 0.5;
        }
        map.put((double) correctNum, (int) map.get((double) correctNum) + 1);
    }

    Map getMap() {
        return map;
    }

    float getYield() {
        return 0;
    }

}

