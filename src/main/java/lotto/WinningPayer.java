package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static lotto.Place.*;

enum Place {
    FIRST(7, 2000000000), SECOND(6, 30000000),
    THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000);
    int count;
    int winning;

    Place (int count, int winning) {
        this.count = count;
        this.winning = winning;
    }

    int getCount() {
        return count;
    }

    int getWinning() {
        return winning;
    }
}

public class WinningPayer {
    List<Integer> result = new ArrayList<Integer>();
    float money;
    float winningRate;
    EnumMap<Place,Integer> resultMap = new EnumMap<Place, Integer>(Place.class);

    WinningPayer(List<Integer> result, int money) {
        this.result = result;
        this.money = (float) money;
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

    void calculateWinningRate() {
        float winning = 0;

        for (Place p : Place.values()) {
            winning += resultMap.get(p) * p.getWinning();
        }
        winningRate = winning / money * 100;
    }

    void informResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + resultMap.get(FIFTH) + "개 입니다.");
        System.out.println("4개 일치 (50,000원) - " + resultMap.get(FOURTH) + "개 입니다.");
        System.out.println("5개 일치 (1,500,000원) - " + resultMap.get(THIRD) + "개 입니다.");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + resultMap.get(SECOND) + "개 입니다.");
        System.out.println("6개 일치 (2,000,000,000원) - " + resultMap.get(FIRST) + "개 입니다.");
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }
}

