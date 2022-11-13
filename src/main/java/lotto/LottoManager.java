package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final List<Lotto> lottos;
    private final int buyingMoney;
    private final Map<Rank, Integer> ranks;

    public LottoManager(int buyingMoney) {
        this.buyingMoney = buyingMoney;
        lottos = new ArrayList<>();
        for (int i = 0; i < buyingMoney / 1000; i++) {
            lottos.add(generateRandomLotto());
        }

        ranks = new HashMap<>();
        Rank[] allRanks = Rank.values();
        for (Rank rank : allRanks) {
            ranks.put(rank, 0);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public void calculateTotalRanks(Lotto winningLotto, int winningBonus) {
        for (Lotto lotto : this.lottos) {
            int matchCount = calculateMatchCount(winningLotto, lotto);
            boolean matchBonus = calculateMatchBonus(winningBonus, lotto);

            Rank rank = Rank.getRank(matchCount, matchBonus);
            this.ranks.put(rank, this.ranks.get(rank) + 1);
        }
    }

    private int calculateMatchCount(Lotto winningLotto, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int matchCount = 0;

        for (int number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount += 1;
            }
        }
        return matchCount;
    }

    private boolean calculateMatchBonus(int winningBonus, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(winningBonus);
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    private int calculateTotalReward() {
        Rank[] allRanks = Rank.values();
        int totalReward = 0;
        for (Rank rank : allRanks) {
            totalReward += ranks.get(rank) * rank.getWinningReward();
        }
        return totalReward;
    }

    public float calculateEarningRate() {
        return (float) calculateTotalReward() / (float) buyingMoney;
    }
}
