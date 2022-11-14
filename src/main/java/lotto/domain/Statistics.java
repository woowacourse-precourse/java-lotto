package lotto.domain;

import java.util.HashMap;
import java.util.Map;

class Statistics {
    Map map;

    Statistics() {
        map = new HashMap<Double, Integer>();
        for (double num : Winnings.getCorrectNums()) {
            map.put(num, 0);
        }
    }

    void record(int correctNum, boolean bonus) {
        double _correctNum = correctNum;
        if (_correctNum < 3) {
            return;
        }
        if (_correctNum == 5.0 && bonus) {
            _correctNum += 0.5;
        }
        System.out.println(_correctNum);
        map.put(_correctNum, (int) map.get(_correctNum) + 1);
    }

    Map getMap() {
        return map;
    }

    float getYield(int lottoNum) {
        int totalWinnings = 0;
        for (double num : Winnings.getCorrectNums()) {
            totalWinnings += (int) map.get(num) * Winnings.getWinnings(num);
        }
        return (float) totalWinnings / (lottoNum * 1000) * 100;
    }

}
