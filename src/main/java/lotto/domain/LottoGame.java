package lotto.domain;

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
            createdLotto.printSortedLotto();
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

    private void checkIsPrized(int matchedCount, int bonus) {
        if (bonus != 1) {
            int matchCount = matchCounts.get(matchedCount);
            matchCounts.set(matchedCount, matchCount + 1);
        }
    }

    public void printWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchCounts.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchCounts.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchCounts.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchCounts.get(7) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchCounts.get(6) + "개");
    }

    public float calculateTotalEarning() {
        float total = 0.0F;
        Prize three = Prize.CALCULATE_THREE;
        total += three.calculate(matchCounts.get(3));
        Prize four = Prize.CALCULATE_FOUR;
        total += four.calculate(matchCounts.get(4));
        Prize five = Prize.CALCULATE_FIVE;
        total += five.calculate(matchCounts.get(5));
        Prize six = Prize.CALCULATE_SIX;
        total += six.calculate(matchCounts.get(6));
        Prize bonus = Prize.CALCULATE_BONUS;
        total += bonus.calculate(matchCounts.get(7));

        return total;
    }

}
