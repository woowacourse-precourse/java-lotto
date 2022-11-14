package YieldMachine;

import User.User;
import lotto.BoughtLotto;
import lotto.WinningNumberLotto;

import java.util.ArrayList;
import java.util.List;

public class YieldMachine {

    private static final Integer LOTTO_COST = 1000;
    private static final Integer MAX_COUNT_OF_LOTTO_NUMBER = 6;
    private WinningNumberLotto winningNumberLotto;
    private List<Integer> countOfRewards;
    private float yield;

    public YieldMachine() {
        this.winningNumberLotto = new WinningNumberLotto();
        this.countOfRewards = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        this.yield = 0;
    }

    public YieldMachine(List<Integer> numbers, int number) {
        this.winningNumberLotto = new WinningNumberLotto(numbers, number);
        this.countOfRewards = new ArrayList<>(List.of(0, 0, 0, 0, 0));
        this.yield = 0;
    }

    public void run() {

    }

    public void calculateYield(User user) {
        List<BoughtLotto> boughtLottos = user.getLottos();
        calculateAllLottoReward(boughtLottos);
        float totalCost = boughtLottos.size() * LOTTO_COST;
        float totalYield = 0;
        for (Reward reward: Reward.values()) {
            int countOfReward = countOfRewards.get(reward.getIndex());
            int rewardPrize = reward.getPrize();
            totalYield += countOfReward * rewardPrize;
        }
        this.yield = totalYield / totalCost;
    }

    private void calculateOneLottoReward(BoughtLotto boughtLotto) {
        List<Integer> numberOfMatching = findCountOfSameNumberWithWinningNumber(boughtLotto);
        Reward reward = Reward.getReward(numberOfMatching);
        if (reward != null) {
            int index = reward.getIndex();
            countOfRewards.set(index, countOfRewards.get(index) + 1);
        }
    }

    private void calculateAllLottoReward(List<BoughtLotto> boughtLottos) {
        for (BoughtLotto boughtLotto: boughtLottos) {
            calculateOneLottoReward(boughtLotto);
        }
    }

    private List<Integer> findCountOfSameNumberWithWinningNumber(BoughtLotto boughtLotto) {
        List<Integer> matchingNumber = new ArrayList<>(List.of(0, 0));
        for (Integer winningNumberLottoNumber: winningNumberLotto.getLotto()) {
            if (boughtLotto.getLotto().contains(winningNumberLottoNumber)) {
                matchingNumber.set(0, matchingNumber.get(0) + 1);
            }
        }
        if (boughtLotto.getLotto().contains(winningNumberLotto.getBonusNumber()) && matchingNumber.get(0) == 5) {
            matchingNumber.set(1, 1);
        }
        return matchingNumber;
    }

    private void printYield() {

    }

    public List<Integer> getCountOfRewards() {
        return this.countOfRewards;
    }

    public float getYield() {
        return yield;
    }
}
