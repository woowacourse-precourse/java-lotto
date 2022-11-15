package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Player {

    private Map<Rank, Integer> statistics;

    public Player() {
        this.statistics = new TreeMap<>(Collections.reverseOrder());
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public void calculateRankStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        initRankStatistics();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.match(winningLotto);
            boolean bonusMatch = lotto.matchBonus(winningLotto.getBonusNumber());
            Rank rank = Rank.of(matchCount, bonusMatch);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }
    }

    private void initRankStatistics() {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
    }

    public String calculateEarningRatio(int lottoCount) {
        double earning = 0;
        int money = lottoCount * LottoMachine.LOTTO_PER_PRICE;

        for (Rank rank : statistics.keySet()){
            int matchCount = statistics.get(rank);
            int reward = rank.getReward();
            earning += matchCount * reward;
        }

        return String.format("%.1f", (earning / money) * 100);
    }
}
