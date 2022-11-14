package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Prize, Integer> result = new HashMap<Prize, Integer>();
    private long totalMoney = 0;

    // 당첨 내역을 추가한다.
    public void addPrize(Prize prize) {
        Integer count = result.putIfAbsent(prize, 1);
        if (count != null) {
            result.put(prize, count + 1);
        }
        totalMoney += prize.getPrizeMoney();
    }

    // 전체 당첨 금액을 반환합니다.
    public long getTotalMoney() {
        return totalMoney;
    }
//    public int calcMoney() {
//        int total = 0;
//        for(Prize prize : result.keySet()) {
//            int prizeMoney = prize.getPrizeMoney();
//            int count = result.get(prize);
//            total += count * prizeMoney;
//        }
//        return total;
//    }
}
