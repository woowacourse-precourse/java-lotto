package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stats {
    Map<Prize, Integer> prizeMap;

    public Stats(List<Lotto> tickets, List<Integer> winningNumbers, Integer bonus) {
        List<Prize> prizeList = new ArrayList<>();
        for(Lotto lotto : tickets){
            prizeList.add(lotto.getPrize(winningNumbers, bonus));
        }
        prizeMap = new HashMap<>();
        for (Prize prize : Prize.values()) {
            prizeMap.put(prize, 0);
        }
        for (Prize prize : prizeList) {
            prizeMap.put(prize, prizeMap.get(prize) + 1);
        }
    }

    public double getRate() {
        double yearn = 0;
        double price = 0;
        for (Prize key : prizeMap.keySet()) {
            yearn += prizeMap.get(key) * key.getMoney();
            price += prizeMap.get(key) * 1000;
        }
        return yearn / price;
    }

    public void printStatus() {
        System.out.println("---");
        System.out.println(Prize.FIRST.getMent() + " - " + prizeMap.get(Prize.FIRST) + "개");
        System.out.println(Prize.SECOND.getMent() + " - " + prizeMap.get(Prize.SECOND) + "개");
        System.out.println(Prize.THIRD.getMent() + " - " + prizeMap.get(Prize.THIRD) + "개");
        System.out.println(Prize.FORTH.getMent() + " - " + prizeMap.get(Prize.FORTH) + "개");
        System.out.println(Prize.FIFTH.getMent() + " - " + prizeMap.get(Prize.FIFTH) + "개");
        String yearnRate = String.format("%.1f", getRate() * 100);
        System.out.println("총 수익률은 " + yearnRate + "%입니다.");
    }
}
