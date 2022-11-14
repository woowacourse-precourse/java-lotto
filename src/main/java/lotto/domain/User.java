package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private int money;
    private long totalPrize;
    private int numberOfLotteries;
    private double rateOfReturn;
    private List<Lotto> lotteries;
    private Map<Result, Integer> winningLotteryCounts = new TreeMap<>();

    public User() {
        for (Result result : Result.values()) {
            winningLotteryCounts.put(result, 0);
        }
    }

    public void purchaseLottery(LotteryMachine lotteryMachine) {
        this.money = lotteryMachine.getUserMoneyInput();
        this.numberOfLotteries = lotteryMachine.calculateNumOfLotteries(this.money);
        this.lotteries = lotteryMachine.generateLotteries(this.numberOfLotteries);
    }

    public int getMoney() {
        return money;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public int getNumberOfLotteries() {
        return numberOfLotteries;
    }

    public List<Lotto> getLotteries() { // for test Only, it will be deleted
        return lotteries;
    }

    public Map<Result, Integer> getWinningLotteryCounts() {
        return winningLotteryCounts;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setTotalPrize(long totalPrize) {
        this.totalPrize = totalPrize;
    }

    public void setNumberOfLotteries(int numberOfLotteries) {
        this.numberOfLotteries = numberOfLotteries;
    }

    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public void setLotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
