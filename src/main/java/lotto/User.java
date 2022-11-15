package lotto;

import static constance.Values.*;
import static lotto.Game.*;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Lotto> lotteries;
    private List<List<Result>> results;
    private int lotteryCount;
    private int winnings;
    private float lotteryStat;

    public User(int amount) {
        init(amount);
    }

    public User(String input) {
        int amount;
        amount = checker.checkAmountInput(input);
        init(amount);
    }

    private void init(int amount) {
        checker.checkNegative(amount);
        checker.checkPayment(amount);
        checker.checkRemain(amount);
        setLotteryCount(amount);
        makeLotteries();
        results = new ArrayList<>();
        setResultsReady();
        winnings = 0;
    }

    private void setLotteryCount(int amount) {
        this.lotteryCount = amount / 1000;
    }

    private void makeLotteries() {
        this.lotteries = new ArrayList<>();
        for (int i = 0; i < lotteryCount; ++i) {
            lotteries.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public List<Lotto> getLotteries() {
        List<Lotto> lotteries = new ArrayList<>();
        for (Lotto lotto : this.lotteries) {
            Lotto copyLotto = new Lotto(lotto.getNumbers());
            lotteries.add(copyLotto);
        }
        return lotteries;
    }

    public String getLotteryList() {
        StringBuffer resultBuffer = new StringBuffer();
        for (Lotto lotto : lotteries) {
            resultBuffer.append(lotto + "\n");
        }
        return resultBuffer.toString();
    }

    public int getLotteryCount() {
        return lotteryCount;
    }

    public void setResultsReady() {
        for (int i = 0; i < WINNINGS.length; ++i) {
            results.add(new ArrayList<>());
        }
    }

    public void setResults(List<Result> results) {
        for (Result result : results) {
            int coincideCount = result.getCoincideCount();
            int bonus = result.getBonus();
            int bonusCount = 0;
            if (bonus > 0 && coincideCount == 5) {
                bonusCount = 2;
            }
            this.results.get(coincideCount + bonusCount).add(result);
        }
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public int getWinnings() {
        return winnings;
    }

    public List<List<Result>> getResults() {
        return results;
    }

    public void setLotteryStat(float lotteryStat) {
        this.lotteryStat = lotteryStat;
    }

    public float getLotteryStat() {
        return lotteryStat;
    }

}
