package lotto.logic;

import java.util.Map;

public class Rank {
    public double accumulation;
    public double earningrate;

    public double getearningRate(Map<Integer, Integer> map, int cnt) {
        accumulation += getRankfive(map) * 5000;
        accumulation += getRankfour(map) * 50000;
        accumulation += getRankthree(map) * 1500000;
        accumulation += getranktwo(map) * 30000000;
        accumulation += getrankone(map) * 2000000000;
        earningrate = (accumulation / cnt) * 100;
        return earningrate;
    }

    public int getRankfive(Map<Integer, Integer> map) {
        return map.get(5);
    }

    public int getRankfour(Map<Integer, Integer> map) {
        return map.get(4);
    }

    public int getRankthree(Map<Integer, Integer> map) {
        return map.get(3);
    }

    public int getranktwo(Map<Integer, Integer> map) {
        return map.get(2);
    }

    public int getrankone(Map<Integer, Integer> map) {
        return map.get(1);
    }
}
