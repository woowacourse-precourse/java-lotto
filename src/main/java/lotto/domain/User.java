package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private int money;
    private int totalPrize;
    private int numberOfLotteries;
    private double rateOfReturn;
    private List<Lotto> lotteries;
    private Map<Result, Integer> winningLotteryCounts = new TreeMap<>();

    public User() {
        for (Result result : Result.values()) {
            winningLotteryCounts.put(result, 0);
        }
    }
    public int getMoney() {
        return money;
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

    public void setNumberOfLotteries(int numberOfLotteries) {
        this.numberOfLotteries = numberOfLotteries;
    }

    public void setLotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }
}
