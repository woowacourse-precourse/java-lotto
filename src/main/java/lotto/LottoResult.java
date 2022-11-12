package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final int money;
    private final List<Integer> resultOfLotto;
    private int total = 0;
    private String profitPercentege;
    private String result = "";

    public LottoResult(int money, List<Integer> resultOfLotto) {
        this.money = money;
        this.resultOfLotto = resultOfLotto;
    }

    private static final Map<Integer, String> rewardMsg = new HashMap<>();
    static {
        rewardMsg.put(5, "3개 일치 (5,000원) - ");
        rewardMsg.put(4, "4개 일치 (50,000원) - ");
        rewardMsg.put(3, "5개 일치 (1,500,000원) - ");
        rewardMsg.put(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        rewardMsg.put(1, "6개 일치 (2,000,000,000원) - ");
    }
    private static final Map<Integer, Integer> reward = new HashMap<>();
    static {
        reward.put(5, 5000);
        reward.put(4, 50000);
        reward.put(3, 1500000);
        reward.put(2, 30000000);
        reward.put(1, 2000000000);
    }

    public String getResult() {
        make();
        return result;
    }

    private void make() {
        for (int i = 5; i >= 1; i--) {
            Integer count = resultOfLotto.get(i-1);
            result += updateResult(rewardMsg.get(i), count);
            total += getReward(reward.get(i), count);
        }
        updatePercentege();
        result += "총 수익률은 "+profitPercentege+"%입니다.";
    }

    private static String updateResult(String s, Integer count) {
        return s + count + "개\n";
    }

    private int getReward(int i, Integer integer) {
        return i * integer;
    }

    private void updatePercentege() {
        double a = (total/(double)money)*100;
        double round = Math.round((a * 10))/10.0;
        profitPercentege = String.format("%.1f", round);
    }
}
