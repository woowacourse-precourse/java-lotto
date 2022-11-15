package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

enum Place {
    FIRST(7, 2000000000), SECOND(6, 30000000),
    THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000);
    int count;
    int winning;

    Place (int count, int winning) {ㄹㄷ
        this.count = count;
        this.winning = winning;
    }

    int getCount() {
        return count;
    }
}

public class WinningPayer {
    List<Integer> result = new ArrayList<Integer>();
    int money;
    EnumMap<Place,Integer> resultMap = new EnumMap<Place, Integer>(Place.class);

    WinningPayer(List<Integer> result, int money) {
        this.result = result;
        this.money = money-money%1000;
    }

    void makeEnumMap() {
        for (Place p : Place.values()) {
            resultMap.put(p, 0);
        }
    }

    void countResult(int count) {
        for (Place p : Place.values()) {
            if (count == p.getCount()) {
                resultMap.put(p, resultMap.get(p) + 1);
            }
        }
    }

    void countPrize() {
        for (int i : result) {
            countResult(i);
        }
    }
}

