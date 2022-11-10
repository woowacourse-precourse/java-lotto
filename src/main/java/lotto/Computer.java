package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private static final Map<Integer, Integer> placeMap = new HashMap<>();

    void init() {
        placeMap.clear();
        placeMap.put(60, 0);
        placeMap.put(51, 0);
        placeMap.put(50, 0);
        placeMap.put(40, 0);
        placeMap.put(30, 0);
    }

    public List<Integer> getResult(List<Lotto> lottos, List<Integer> winns, int bonus) {
        updatePlaceMap(lottos, winns, bonus);
        return getStatistics();
    }

    private void updatePlaceMap(List<Lotto> lottos, List<Integer> winns, int bonus) {
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int ranking = lotto.getRanking(winns, bonus);
            Integer integer = placeMap.get(ranking);
            if (isNull(integer)) continue;
            placeMap.put(ranking, integer + 1);
        }
    }

    private static boolean isNull(Integer integer) {
        return integer == null;
    }

    private List<Integer> getStatistics() {
        List<Integer> result = new ArrayList<>();
        for (int i = 60; i >= 30; i -= 10) {
            if (i == 50) {
                Integer integer2 = placeMap.get(i + 1);
                result.add(integer2);
            }
            Integer integer = placeMap.get(i);
            result.add(integer);
        }
        return result;
    }
}
