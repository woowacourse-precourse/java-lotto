package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static java.util.Arrays.asList;

public class LottoGame {
    private final static int WIN = 0;
    private final static int SECOND = 0;
    private final static int THIRD = 0;
    private final static int FOURTH = 0;
    private final static int FIFTH = 0;

    private List<Lotto> lotteries;
    private List<Integer> matchCounts;

    public LottoGame() {
        lotteries = new ArrayList<>();
        matchCounts = new ArrayList<>(asList(0, 0, 0, 0, 0, 0, 0, 0)); // 0,1,2,3,4,5,6,bonus
    }

    public void createLotto(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            Lotto createdLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            addLotto(createdLotto);
        }
    }

    private void addLotto(Lotto lotto) {
        lotteries.add(lotto);
    }

    public void printLotteries(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            Lotto createdLotto = lotteries.get(i);
            createdLotto.printCreatedLotto();
        }
    }

    public void confirmLotteriesPrized(Lotto winningLotto, int bonusNumber) {
        Set<Integer> winningLottoNumbers = new HashSet<>(winningLotto.getNumbers());
        List<Integer> count;
        int matchedCount;
        int bonus;
        for (Lotto lotto : lotteries) {
            count = lotto.countMatch(winningLottoNumbers, bonusNumber);
            matchedCount = count.get(0);
            bonus = count.get(1);
            checkIsBonusPrized(matchedCount, bonus);
            checkIsPrized(matchedCount, bonus);
        }
    }

    private void checkIsBonusPrized(int matchedCount, int bonus) {
        int matchCount;
        if (bonus == 1 && matchedCount == 5) {
            matchCount = matchCounts.get(matchedCount);
            matchCounts.set(matchCounts.size() - 1, matchCount + 1);
        }
    }
}
