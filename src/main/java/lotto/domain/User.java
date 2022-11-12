package lotto.domain;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

    private int money;
    private int totalPrize;
    private int numberOfLotteries;
    private double rateOfReturn;
    private List<Lotto> lotteries;


    public int getMoney() {
        return money;
    }

    public int getNumOfLotteries() {
        return numberOfLotteries;
    }

    public List<Lotto> getLotteries() { // for test Only, it will be deleted
        return lotteries;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setNumberOfLotteries(int numberOfLotteries) {
        this.numberOfLotteries = numberOfLotteries;
    }

    public void setLotteries(LotteryMachine lotteryMachine) {
        lotteries = lotteryMachine.generateLotteries(numberOfLotteries);
    }


}
