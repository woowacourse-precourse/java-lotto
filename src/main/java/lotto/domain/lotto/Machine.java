package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
    public Lotto draw() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> draw(int count) {
        List<Lotto> lottos = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            lottos.add(draw());
        }

        return lottos;
    }

    private int compare(Lotto winningLotto, Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int count = 0;
        for (Integer number : numbers) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    public Map<Rank, Integer> checkRanking(WinningNumber winningNumber, Lotto... lottos) {
        Map<Rank, Integer> rankings = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankings.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = checkRanking(winningNumber, lotto);
            rankings.put(rank, rankings.get(rank) + 1);
        }
        return rankings;
    }

    public Rank checkRanking(WinningNumber winningNumber, Lotto lotto) {
        int count = compare(winningNumber.lotto, lotto);
        if (count == 6) {
            return Rank.FIRST;
        }
        if (count == 5) {
            if (checkBonusNumber(lotto, winningNumber.bonusNumber)) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        if (count == 4) {
            return Rank.FOURTH;
        }
        if (count == 3) {
            return Rank.FIFTH;
        }
        return Rank.LOSE;
    }

    private boolean checkBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public double calculateYieldRate(Map<Rank, Integer> ranks) {
        long sum = 0;
        int totalCount = 0;
        for (Rank rank : ranks.keySet()) {
            int count = ranks.get(rank);
            sum += (count * rank.getPrize());
            totalCount += count;
        }

        double yieldRate = sum / ((double) totalCount * Lotto.PRICE) * 100;
        return yieldRate;
    }
}
