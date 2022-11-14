package lotto.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final List<Lotto> lottos;
    private final int buyingMoney;
    private final Map<Rank, Integer> ranks;

    public static final int LOTTO_RANGE_START = 1;
    public static final int LOTTO_RANGE_END = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_COUNT = 6;

    public LottoManager(int buyingMoney, NumberGenerator numberGenerator) {
        this.buyingMoney = buyingMoney;
        lottos = new ArrayList<>();
        for (int i = 0; i < buyingMoney / LOTTO_PRICE; i++) {
            lottos.add(new Lotto(numberGenerator.generateLottoNumber()));
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

    private int calculateTotalReward() {
        Rank[] allRanks = Rank.values();
        int totalReward = 0;
        for (Rank rank : allRanks) {
            totalReward += ranks.get(rank) * rank.getWinningReward();
        }
        return totalReward;
    }

    public float calculateEarningRate() {
        return (float) calculateTotalReward() / (float) buyingMoney * 100f;
    }
}
