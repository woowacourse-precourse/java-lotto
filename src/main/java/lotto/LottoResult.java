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

    // 특정 등수에 몇개가 당첨됬는지 반환합니다.
    public int countPrize(Prize prize) {
        Integer count = result.get(prize);
        if(count == null) {
            return 0;
        }
        return count;
    }
}
