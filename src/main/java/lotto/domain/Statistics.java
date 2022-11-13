package lotto.domain;

import java.util.HashMap;
import java.util.Map;

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
        Map winnings = new HashMap<Double, Integer>();
        int totalWinnings = 0;
        double[] correctNums = {3, 4, 5, 5.5, 6};
        int[] cash = {5000, 50000, 1500000, 30000000, 2000000000};
        for (int i = 0; i < correctNums.length; i++) {
            winnings.put(correctNums[i], cash[i]);
        }
        for (double num : correctNums) {
            totalWinnings += (int) map.get(num) * (int) winnings.get(num);
        }
        return (float) totalWinnings / (lottoNum * 1000) * 100;
    }

}
