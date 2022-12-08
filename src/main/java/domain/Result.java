package domain;

import domain.lotto.BonusNumber;
import domain.lotto.Lotto;
import domain.lotto.Lottos;

public class Result {

    boolean bonus_index = false;

    public int count = 0;
    public double total_prize = 0;
    public int[] winning = new int[5];

    public void compareNumbers(Lottos userLotteries, Lotto winningLotto, BonusNumber bonus) {
        for (int sheet = 0; sheet < userLotteries.size(); sheet++) {
            Lotto lotto = userLotteries.get(sheet);
            compareEachLotto(winningLotto, bonus, lotto);
            calculateResult();
            initializeIndex();
        }
    }

    public void compareEachLotto(Lotto winningLotto, BonusNumber bonus, Lotto lotto) {
        for (int order = 0; order < lotto.size(); order++) {
            if (winningLotto.contains(lotto.get(order))) {
                count++;
            }
            if (lotto.get(order) == bonus.getBonusNumber()) {
                bonus_index = true;
            }
        }
    }

    private void calculateResult() {
        winFirst();
        winSecond();
        winThird();
        winFourth();
        winFifth();
    }

    public double calculateEarningRate(double total_prize, Money money) {
        return total_prize / money.getMoney() * 100;
    }

    private void winFifth() {
        if (count == 3) {
            winning[0]++;
            total_prize += Rank.FIFTH.getReward();
        }
    }

    private void winFourth() {
        if (count == 4) {
            winning[1]++;
            total_prize += Rank.FOURTH.getReward();
        }
    }

    private void winThird() {
        if (count == 5 && !bonus_index) {
            winning[2]++;
            total_prize += Rank.THIRD.getReward();
        }
    }

    private void winSecond() {
        if (count == 5 && bonus_index) {
            winning[3]++;
            total_prize += Rank.SECOND.getReward();
        }
    }

    private void winFirst() {
        if (count == 6) {
            winning[4]++;
            total_prize += Rank.FIRST.getReward();
        }
    }

    private void initializeIndex() {
        count = 0;
        bonus_index = false;
    }
}
