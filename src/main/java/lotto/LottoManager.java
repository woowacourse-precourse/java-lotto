package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private List<Lotto> lotties;
    private final int buyingMoney;
    private Map<Rank,Integer> ranks;

    public LottoManager(int buyingMoney) {
        this.buyingMoney = buyingMoney;
        lotties = new ArrayList<>();
        for (int i = 0; i < buyingMoney / 1000; i++) {
            lotties.add(generateRandomLotto());
        }

        ranks = new HashMap<>();
        Rank[] allRanks = Rank.values();
        for (Rank rank: allRanks) {
            ranks.put(rank,0);
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
        int matchCount = 0;
        return numbers.contains(winningBonus);
    }

    private Lotto generateRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
