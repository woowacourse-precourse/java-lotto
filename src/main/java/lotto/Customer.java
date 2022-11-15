package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static final int RANK_NUM = 5;
    private final List<Lotto> lottoNumbers;
    private final List<Integer> winningCount;
    private final int money;
    private final int lottoCount;
    private int totalReward;


    public Customer(int money) {
        winningCount = new ArrayList<>();
        validateMoney(money);
        this.money = money;
        lottoCount = money / 1000;
        lottoNumbers = new ArrayList<>();
        totalReward = 0;
        initRankCount();
    }

    private void initRankCount() {
        for (int i = 0; i < RANK_NUM; i++) {
            winningCount.add(0);
        }
    }

    private void validateMoney(int money) {
        if (money < 1000 || money % 1000 > 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MONEY.getMessage());
        }
    }

    public void purchaseLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new Lotto(Utils.getRandomNumbers()));
        }
    }

    private void addRankCount(int rank) {
        winningCount.set(rank - 1, winningCount.get(rank - 1) + 1);
    }

    private void addReward(int reward) {
        totalReward += reward;
    }

    private void checkPrize(PrizeCode prizeCode) {
        if (prizeCode.getRank() != -1) {
            addRankCount(prizeCode.getRank());
            addReward(prizeCode.getReward());
        }
    }

    public void checkWinning(WinningInfo winningInfo) {
        for (Lotto lotto : lottoNumbers) {
            PrizeCode prizeCode = winningInfo.compare(lotto);
            checkPrize(prizeCode);
        }
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getWinningCount() {
        return winningCount;
    }

    public double getRate() {
        return totalReward / Double.valueOf(money) * 100;
    }
}
