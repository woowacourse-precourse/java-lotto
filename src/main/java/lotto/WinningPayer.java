package lotto;

import java.util.EnumMap;
import java.util.List;

import static lotto.Place.*;

enum Place {
    FIRST(7, 2000000000), SECOND(6, 30000000),
    THIRD(5, 1500000), FOURTH(4, 50000), FIFTH(3, 5000);
    private int count;
    private int prize;

    Place (int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    int getCount() {
        return count;
    }

    int getPrize() {
        return prize;
    }
}

public class WinningPayer {
    private final List<Integer> comparisonResult;
    private final float money;
    private float profitRate;
    private EnumMap<Place,Integer> prizeResult = new EnumMap<Place, Integer>(Place.class);

    WinningPayer(List<Integer> result, int money) {
        this.comparisonResult = result;
        this.money = (float) money;
        for (Place p : Place.values()) {
            prizeResult.put(p, 0);
        }
    }

    void transformResult(int count) {
        for (Place p : Place.values()) {
            if (count == p.getCount()) {
                prizeResult.put(p, prizeResult.get(p) + 1);
            }
        }
    }

    void repeatTransforamtion() {
        for (int count : comparisonResult) {
            transformResult(count);
        }
    }

    void calculateWinningRate() {
        float prizeTotal = 0;

        for (Place p : Place.values()) {
            prizeTotal += prizeResult.get(p) * p.getPrize();
        }
        profitRate = prizeTotal / money * 100;
    }

    void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeResult.get(FIFTH) + "개 입니다.");
        System.out.println("4개 일치 (50,000원) - " + prizeResult.get(FOURTH) + "개 입니다.");
        System.out.println("5개 일치 (1,500,000원) - " + prizeResult.get(THIRD) + "개 입니다.");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeResult.get(SECOND) + "개 입니다.");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeResult.get(FIRST) + "개 입니다.");
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}

