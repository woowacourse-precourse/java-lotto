package lotto.domain;

import lotto.Lotto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistic {
    private final LottoBundle lottoBundle;
    private final int bonus_num;
    private final Lotto win_lotto;
    private final int cost;

    private Map<Rank, Integer> rankMap = new HashMap<>();
    private double profitRate = 0;

    public LottoStatistic(LottoBundle lottoBundle, int bonus_num, Lotto win_lotto, int cost) {
        this.lottoBundle = lottoBundle;
        this.bonus_num = bonus_num;
        this.win_lotto = win_lotto;
        this.cost = cost;
        compareBundle();
        calculateProfitRate();
    }

    @Override
    public String toString() {

        String print = "\n당첨 통계\n";
        print += "---\n";
        for (Rank rank : Rank.values()) {
            print += summarizeRank(rank);
        }
        print += "총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.";
        return print;
    }

    public String summarizeRank(Rank rank) {
        DecimalFormat df = new DecimalFormat("###,###");
        int count = rank.getCounts();
        String price = df.format(rank.getPrice());
        int quantity = rankMap.getOrDefault(rank, 0);

        String str = count + "개 일치";
        if (rank == Rank.Second_Place)
            str += ", 보너스 볼 일치";
        str += " (" + price + "원) - ";
        str += quantity + "개\n";

        return str;
    }

    private void calculateProfitRate() {
        for (Map.Entry<Rank, Integer> entry : rankMap.entrySet()) {
            Rank rank = entry.getKey();
            Integer value = entry.getValue();
            profitRate += rank.getPrice() * value;
        }
        if (cost != 0)
            profitRate /= cost;
        profitRate *= 100;
    }

    private void compareBundle() {
        for (Lotto lotto : lottoBundle.getLottoList()) {
            int count = compareWin_lotto(lotto);
            boolean bonus = compareBonusNum(lotto);
            putResultToMap(count, bonus);
        }
    }

    private void putResultToMap(int count, boolean bonus) {
        for (Rank rank : Rank.values()) {
            if (count == rank.getCounts() && bonus == rank.isBonus()) {
                rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
            }
        }
    }

    public int compareWin_lotto(Lotto lotto) {
        int count = 0;
        for (int user_num : lotto.getNumbers()) {
            if (win_lotto.getNumbers().contains(user_num))
                count++;
        }
        return count;
    }

    private boolean compareBonusNum(Lotto lotto) {
        return lotto.getNumbers().contains(bonus_num);
    }
}
